package Synchronization;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Synchro s1 = new Synchro();
        NewThread n1 = new NewThread(s1);
        NewThread n2 = new NewThread(s1);
        n1.start();
        n2.start();
        n1.join();
        n2.join();
        System.out.println(s1.getCounter());
    }
}
