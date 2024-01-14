/**
 * Klasa implementująca interfejs Runnable do wykonywania wyciągów z konta bankowego - synchronizacja wątków.
 */
public class WithdrawThreadSynchronized implements Runnable {
    private SharedBank bank;
    private int amount;

    /**
     * Konstruktor przyjmujący dwa parametry
     * @param bank konto bankowe
     * @param amount kwota pieniędzy do pobrania
     */
    public WithdrawThreadSynchronized(SharedBank bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    /**
     * Metoda odpowiedzialna za wykonanie wątku
     */
    @Override
    public synchronized void run() {
        synchronized (getBank()) {
            getBank().withdraw(getAmount());
            System.out.println("Na koncie zostało: " + getBank().getBalance() + " zł");
        }
    }

    /**
     * Metoda zwracająca zadaną kwotę do pobrania
     * @return kwota pieniędzy do pobrania
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Metoda ustawiająca nową kwotę do pobrania
     * @param amount nowa kwota pieniędzy do pobrania
     * @throws IllegalArgumentException gdy amount <= 0
     */
    public void setAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Podana kwota musi być dodatnia.");
        }
        else {
            this.amount = amount;
        }
    }

    /**
     * Metoda zwracająca konto bankowe
     * @return konto bankowe
     */
    public SharedBank getBank() {
        return bank;
    }

    /**
     * Metoda ustawiająca nowe konto bankowe
     * @param bank nowe konto bankowe
     */
    public void setBank(SharedBank bank) {
        this.bank = bank;
    }
}