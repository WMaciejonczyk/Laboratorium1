/**
 * Program opierający się na działaniu współbieżnym
 */
public class Lista8Demo {
    /**
     * Klasa Lista8Demo
     * @param args badane wątki wykonujące program zadany przez klasy Counter, Numbers, SharedBank, WithdrawThread, WithdrawThreadSynchronized
     * @throws InterruptedException gdy wątek zostaje przerwany
     */
    public static void main(String[] args) throws InterruptedException {
        // Zadanie 2
        Counter c = new Counter();
        Thread thread1 = new Thread(new Numbers(c));
        Thread thread2 = new Thread(new Numbers(c));
        Thread thread3 = new Thread(new Numbers(c));
        Thread thread4 = new Thread(new Numbers(c));
        Thread thread5 = new Thread(new Numbers(c));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        System.out.println(c.getCount());
        System.out.println(" ");
        // Zadanie 3a
        System.out.println("Zadanie 3 - brak synchronizacji wątków");
        SharedBank bank = new SharedBank(10000);
        WithdrawThread withdraw1 = new WithdrawThread(bank, 1500);
        WithdrawThread withdraw2 = new WithdrawThread(bank, 6500);
        Thread threadw1 = new Thread(withdraw1);
        Thread threadw2 = new Thread(withdraw2);
        threadw1.start();
        threadw2.start();

        threadw1.join();
        threadw2.join();

        System.out.println(" ");
        // Zadanie 3b
        System.out.println("Zadanie 3 - synchronizacja wątków");
        SharedBank bank2 = new SharedBank(10000);
        WithdrawThreadSynchronized withdraw3 = new WithdrawThreadSynchronized(bank2, 3000);
        WithdrawThreadSynchronized withdraw4 = new WithdrawThreadSynchronized(bank2, 4000);
        Thread threadw3 = new Thread(withdraw3);
        Thread threadw4 = new Thread(withdraw4);
        threadw3.start();
        threadw4.start();
    }
}
