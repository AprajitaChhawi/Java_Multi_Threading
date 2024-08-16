package CyclicBarrier;

import java.util.concurrent.*;

public class Cyclic_Barrier {
    public static void main(String[] args) {
        int number = 3;
        ExecutorService service = Executors.newFixedThreadPool(number);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(number);
        service.submit(new Dependent2(cyclicBarrier));
        service.submit(new Dependent2(cyclicBarrier));
        service.submit(new Dependent2(cyclicBarrier));
        System.out.println("Main");
        service.shutdown();
    }
}
class Dependent2 implements Callable<String> {
    private final CyclicBarrier cyclicBarrier;

    public Dependent2(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" service started.");
        Thread.sleep(1000);
        cyclicBarrier.await();
        System.out.println(Thread.currentThread().getName()+" service completed.");
        return "ok";
    }
}
