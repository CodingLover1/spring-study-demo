package com.ws;

import java.util.concurrent.*;

/**
 * @author shuo.wang
 * @date 19-9-25
 */
public class FutureDemo {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Callable<Integer> callable = () -> {
                System.out.println("begining...");
                Thread.sleep(1000);
                System.out.println("ending...");

                return 100;
            };

            Future<Integer> result = executorService.submit(callable);
            System.out.println(result.get());
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        }catch (Exception e){

        }

    }
}
