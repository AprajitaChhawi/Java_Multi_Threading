package Read_Write_Locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    private int count = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    public void increment(){
        writeLock.lock();
        try{
            count++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } finally {
            writeLock.unlock();
        }
    }
    public int getCount(){
        readLock.lock();
        try{
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock re = new ReadWriteLock();
        Runnable readtask = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+ " "+re.getCount());
                }
            }
        };
        Runnable writetask = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    re.increment();
                    System.out.println(Thread.currentThread().getName()+ " incremented");
                }
            }
        };
        Thread t1 = new Thread(writetask,"Thread 1");
        Thread t2 = new Thread(readtask,"Thread 2");
        Thread t3 = new Thread(readtask,"Thread 3");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

    }
}
