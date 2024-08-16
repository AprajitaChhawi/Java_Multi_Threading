package Executors_Frameowrk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Executors {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(3);
        for(int i=1;i<10;i++){
            int finalI = i;
            //pass a runnable task inside submit method
            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });
        }
        //can't use executor.submit() again and it will orderly shutdown the threads been created
        //before getting completed , main won't wait for this to end
        executor.shutdown();
        try {
            //main will wait for 100 seconds for it to end and if not , the main will proceed.
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.currentTimeMillis()-startTime);
    }
    private static long factorial(int n)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result=1;
        for(int i=1;i<=n;i++){
            result = result*i;
        }
        return result;
    }
}