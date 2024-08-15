public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        System.out.println(Thread.currentThread().getState());
        Thread.sleep(100);
        System.out.println(t1.getState());
        t1.join(); //joins method waits for whoever(t1 in this case) has called it to get finished and then passes control to next line
        System.out.println(t1.getState());
    }
}
