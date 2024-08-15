package UnFairLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLock {
    private final Lock unfairlock = new ReentrantLock(true);
    public void access(){
        unfairlock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" acquired the lock.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName()+" released the lock.");
            unfairlock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UnfairLock ex = new UnfairLock();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                ex.access();
            }
        };
        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        Thread t3 = new Thread(task,"Thread 3");
        t1.start();
        Thread.sleep(50);
        t2.start();
        Thread.sleep(50);
        t3.start();

    }
}
