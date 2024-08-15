package ExplicitLocks;

import javax.swing.plaf.TableHeaderUI;

public class Main {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        Runnable t1= new Runnable() {
            @Override
            public void run() {
                b1.withdraw(10);
            }
        };
        Thread t2= new Thread(t1,"Thread 1");
        Thread t3= new Thread(t1,"Thread 2");
        t2.start();
        t3.start();
    }
}
