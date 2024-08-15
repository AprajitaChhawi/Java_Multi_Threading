public class Daemon extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        Daemon d1 = new Daemon();
        Daemon d2 = new Daemon();
        d1.setDaemon(true);
        d1.start();
        d2.start();
        System.out.println("Main done");
    }
}