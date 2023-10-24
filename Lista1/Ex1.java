import java.util.Scanner;

/**
 * Zadanie 1.
 */
public class Ex1 {
    /**
     * Program obliczający dystans i wysokość rzutu ukośnego
     * @param args prędkość oraz kąt uderzenia
     * @throws IllegalArgumentException gdy prędkość jest ujemna lub kąt rzutu znajduje się poza zakresem 0-90 stopni
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj prędkość: ");
        double v0 = scanner.nextDouble();
        System.out.println("Podaj kąt uderzenia: ");
        double angle = scanner.nextDouble();
        double angle_radian = Math.toRadians(angle);

        scanner.close();

        if (v0 < 0 || angle < 0 || angle > 90) {
            throw new IllegalArgumentException("Nieprawidłowe dane wejściowe.");
        } else {
            double distance = (Math.pow(v0, 2) * Math.sin(2 * angle_radian)) / 9.81;
            double maxHeight = (Math.pow(v0, 2) * Math.sin(angle_radian) * Math.sin(angle_radian) / (2 * 9.81));

            System.out.println("Zasięg: " + distance + " m");
            System.out.println("Maksymalna wysokość: " + maxHeight + " m");
        }
    }
}
