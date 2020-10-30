package MultiThreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> yourNameFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        });

        CompletableFuture<String> greetingFuture = yourNameFuture.thenApply(name -> " your name -->" + name);

        System.out.println(greetingFuture.get());
    }

}
