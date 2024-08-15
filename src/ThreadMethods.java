import java.sql.SQLOutput;

public class ThreadMethods extends Thread{
    public ThreadMethods(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println("Thread is running");
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" " +Thread.currentThread().getPriority() + " i "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interupption"+e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMethods t1= new ThreadMethods("High Priority");
        t1.setPriority(Thread.MAX_PRIORITY);
        ThreadMethods t2 = new ThreadMethods("Low Priority");
        t2.setPriority(Thread.MIN_PRIORITY);
        ThreadMethods t3 = new ThreadMethods("Medium Priority");
        t3.setPriority(Thread.NORM_PRIORITY);
        t2.start();
        t3.start();
        t1.start();
        t1.interrupt();
        //t1.join(); //main will wait for t1 to get finished
        System.out.println("Hello");
    }
}
