/**
 * Klasa tworząca obiekt licznika.
 */
public class Counter {
    private long count = 0;

    /**
     * Zsynchronizowana metoda inkrementacji licznika
     */
    public synchronized void increment() {
        count = count + 1;
    }

    /**
     * Metoda zwracająca licznik
     * @return
     */
    public long getCount() {
        return count;
    }
}
