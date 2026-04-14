package PW_13.Task2;

public class Task2 {
    static int run(Inventory i) {
        try {
            Thread t1 = new Thread(() -> i.reserve(60));
            Thread t2 = new Thread(() -> i.reserve(60));
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            return i.available();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        System.out.println("unsafe=" + run(new UnsafeInventory(100)));
        System.out.println("safe=" + run(new SynchronizedInventory(100)));
        int bad = 0;
        for (int i = 0; i < 500; i++) {
            if (run(new UnsafeInventory(100)) < 0) bad++;
        }
        System.out.println("violations=" + bad);
    }
}
