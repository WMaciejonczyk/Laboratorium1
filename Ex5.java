import java.util.Scanner;

/**
 * Zadanie 5.
 */
public class Ex5 {
    /**
     * Program obliczający równanie prostej
     * @param args współrzędne dwóch punktów
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj współrzędne pierwszego punktu: ");
        double pierwszyPunktX = scanner.nextDouble();
        double pierwszyPunktY = scanner.nextDouble();
        System.out.println("Podaj współrzędne drugiego punktu: ");
        double drugiPunktX = scanner.nextDouble();
        double drugiPunktY = scanner.nextDouble();

        scanner.close();

        try {
            double[] rowananie = wspolczynniki((pierwszyPunktX, pierwszyPunktY, drugiPunktX, drugiPunktY));
            System.out.println("y = " + rowananie[0] + "x + " + rowananie[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Funkcja obliczająca współczynnik kierunkowy i wyraz wolny równania prostej
     * @param pierwszyPunktX współrzędna x pierwszego punktu
     * @param pierwszyPunktY współrzędna y pierwszego punktu
     * @param drugiPunktX współrzędna x drugiego punktu
     * @param drugiPunktY współrzędna y drugiego punktu
     * @return współczynniki prostej
     * @throws IllegalArgumentException gdy punkty są identyczne
     */
    public static double[] wspolczynniki(double pierwszyPunktX, double pierwszyPunktY, double drugiPunktX, double drugiPunktY) {
        if ((drugiPunktX == pierwszyPunktX) && (drugiPunktY == pierwszyPunktY)){
            throw new IllegalArgumentException("Współrzędne punktów nie mogą być takie same.");
        }
        double a = (drugiPunktY - pierwszyPunktY) / (drugiPunktX - pierwszyPunktX);
        double b = pierwszyPunktY - (a * pierwszyPunktX);
        return new double[]{a, b};
    }
}
