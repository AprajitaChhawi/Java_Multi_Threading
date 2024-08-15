public class Yield extends Thread{
    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield(); //hint for jvm and schedular to yield its current use of a processor
        }
    }

    public static void main(String[] args) {
        Yield y1= new Yield();
        Yield y2= new Yield();
        y1.start();
        y2.start();
    }
}
