package PW_13.Task2;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedInventory implements Inventory{
    private int amount;
    private final ReentrantLock lock = new ReentrantLock();

    public SynchronizedInventory(int amount) {
        this.amount = amount;
    }

    @Override
    public void reserve(int amt) {
        lock.lock();
        try {
            if (amount >= amt) {
                amount -= amt;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int available() {
        lock.lock();
        try {
            return amount;
        } finally {
            lock.unlock();
        }
    }
}