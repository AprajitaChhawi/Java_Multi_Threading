import java.sql.SQLOutput;

public class Test2 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100000;i++) {
            System.out.println("World2 "+Thread.currentThread().getName());
        }
    }
}
