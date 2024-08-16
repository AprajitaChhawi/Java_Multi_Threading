package ScheduledExecutorService;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService schedular = Executors.newScheduledThreadPool(1);
        schedular.schedule(
                ()-> System.out.println("task"),
                5,
                TimeUnit.SECONDS);
        ScheduledExecutorService schedular2 = Executors.newScheduledThreadPool(1);
        schedular2.scheduleAtFixedRate(
                ()-> System.out.println("at every 5 seconds"),
                5,
                5,
                TimeUnit.SECONDS);
        schedular.shutdown();
        schedular2.schedule(()-> {
            System.out.println("shutdown");
            schedular2.shutdown();
        }, 20,TimeUnit.SECONDS);
        ScheduledExecutorService schedular3 = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture = schedular3.scheduleWithFixedDelay(
                () -> System.out.println("at every 5 seconds"),
                5,
                5,
                TimeUnit.SECONDS);
        System.out.println(scheduledFuture.get());
    }
}
