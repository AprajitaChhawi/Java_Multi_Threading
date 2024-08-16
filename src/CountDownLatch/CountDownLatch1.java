package CountDownLatch;

import java.util.concurrent.*;

public class CountDownLatch1 {
    public static void main(String[] args) throws InterruptedException {
        int number =3;
        ExecutorService service = Executors.newFixedThreadPool(number);
        CountDownLatch latch = new CountDownLatch(number);
        Future<String> submit = service.submit(new Dependent1(latch));
        Future<String> submit1 = service.submit(new Dependent1(latch));
        Future<String> submit2 = service.submit(new Dependent1(latch));
        latch.await();
        System.out.println("Done with all tasks");
        service.shutdown();
    }
}
class Dependent1 implements Callable<String> {
    private final CountDownLatch latch;

    public Dependent1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName()+" service started.");
            Thread.sleep(1000);
        }finally {
            latch.countDown();
        }
        return "ok";
    }
}
