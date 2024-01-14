/**
 * Klasa implementująca interfejs Runnable do zwiększania zadanego licznika.
 */
public class Numbers implements Runnable {
    private Counter counter;

    /**
     * Konstruktor przyjmujący jeden parametr
     * @param counter licznik
     */
    public Numbers(Counter counter) {
        this.counter = counter;
    }
    /**
     * Metoda odpowiedzialna za wykonanie wątku
     */
    @Override
    public void run() {
        for (int i = 1; i < 100001; i++) {
            getCounter().increment();
        }
    }

    /**
     * Metoda zwracająca licznik
     * @return licznik
     */
    public Counter getCounter() {
        return counter;
    }

    /**
     * Metoda ustawiająca nowy licznik
     * @param counter nowy licznik
     */
    public void setCounter(Counter counter) {
        this.counter = counter;
    }
}
