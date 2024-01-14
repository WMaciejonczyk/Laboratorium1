public class Counter {
    private long count = 0;
    public synchronized void increment() {
        count = count + 1;
    }

    public long getCount() {
        return count;
    }
}