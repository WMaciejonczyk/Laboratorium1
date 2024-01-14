/**
 * Klasa implementująca interfejs Runnable do drukowania liczb od 1 do 10.
 */
public class Numbers implements Runnable {
    /**
     * Metoda odpowiedzialna za wykonanie wątku
     */
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.print(i + " ");
        }
    }
}
