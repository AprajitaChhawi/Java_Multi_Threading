package CountDownLatch;

import java.util.concurrent.*;

public class WithoutCountDownLatch {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<String> submit = service.submit(new Dependent());
        Future<String> submit1 = service.submit(new Dependent());
        Future<String> submit2 = service.submit(new Dependent());
        submit.get();
        submit1.get();
        submit2.get();
        System.out.println("Done with all the threads");
        service.shutdown();
    }
}

class Dependent implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" service started.");
        Thread.sleep(1000);
        return "ok";
    }
}
