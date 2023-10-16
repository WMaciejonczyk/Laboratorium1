import java.util.Scanner;

/**
 * Zadanie 2.
 */
public class Ex2 {
    /**
     * Program sprawdzający zgodność między łańcuchem referencyjnym a łańcuchem do porównania
     * @param args łańcuch referencyjny oraz łańcuch do porównania
     * @throws IllegalArgumentException gdy łańcuch referencyjny lub łańcuch do porównania jest pusty
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj łańcuch referencyjny: ");
        String reference = scanner.nextLine().toLowerCase();

        if (reference.isEmpty()) {
            throw new IllegalArgumentException("Łańcuch referencyjny nie może być pusty.");
        }    

        while (true) {
            int wrong = 0;
            System.out.print("Podaj łańcuch do porównania: ");
            String compare = scanner.nextLine().toLowerCase();

            if (compare.isEmpty()) {
                throw new IllegalArgumentException("Łańcuch do porównania nie może być pusty.");
            }

            if (compare.equals("stop")) {
                break;
            }

            for (int i = 0; i < compare.length(); i++) {
                int id = reference.indexOf(compare.charAt(i));
                if (id == -1) {
                    wrong += 1;
                }
            }

            if (wrong == 0) {
                System.out.println("Łańcuch poprawny.");
            } else {
                System.out.println("Łańcuch zawiera niedozwolone znaki.");
            }
        }

        scanner.close();
    }
}

