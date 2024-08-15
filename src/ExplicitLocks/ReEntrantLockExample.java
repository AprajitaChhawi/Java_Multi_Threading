package ExplicitLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockExample {
    private final Lock lock = new ReentrantLock();
    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("Outer Method");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }
    public void innerMethod(){
        lock.lock(); //re-entered the lock is allowed using ReentrantLock if same thread is using it
        try{
            System.out.println("Inner method");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReEntrantLockExample re = new ReEntrantLockExample();
        ReEntrantLockExample re2 = new ReEntrantLockExample();
        re.outerMethod();
        re2.outerMethod();
    }
}
