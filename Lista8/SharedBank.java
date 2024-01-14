/**
 * Klasa tworząca obiekty reprezentujące konta bankowe.
 */
public class SharedBank {
    private int balance;

    /**
     * Konstruktor przyjmujący jeden parametr
     * @param balance ilość pieniędzy na koncie
     * @throws IllegalArgumentException gdy balance < 0
     */
    public SharedBank(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Niemożliwa ilość pieniędzy na koncie.");
        }
        else {
            this.balance = balance;
        }
    }

    /**
     * Metoda pobierająca z konta podaną kwotę
     * @param amount zadana kwota
     * @throws IllegalArgumentException gdy amount > currentBalance
     */
    public void withdraw(int amount) {
        int currentBalance = getBalance();
        if (amount <= currentBalance) {
            setBalance(currentBalance - amount);
            System.out.println("Wybrano z konta: " + amount + " zł");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Nie ma tyle środków na koncie.");
        }
    }

    /**
     * Metoda zwracająca aktualny stan konta
     * @return stan konta
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Metoda ustawiająca nowy stan konta
     * @param balance nowy stan konta
     * @throws IllegalArgumentException gdy balance < 0
     */
    public void setBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Podana kwota nie może być ujemna.");
        }
        else {
            this.balance = balance;
        }
    }
}
