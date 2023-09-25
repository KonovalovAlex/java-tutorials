package tutorials.tutorials.multithreading.completableFuture;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFutureExam {
    public CompletableFutureExam() throws ExecutionException, InterruptedException {
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        String result;
        //The get() method blocks until the Future is complete. So, the above call will block forever because the Future is never completed.
        // result = completableFuture.get();
//        You can use CompletableFuture.complete() method to manually complete a Future -
//       completableFuture.complete("Future's Result")

//-----------------------------------------------------------------------------------------------------------------------------------------
        // Run a task specified by a Runnable Object asynchronously.
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Simulate a long-running Job
            try {
                TimeUnit.SECONDS.sleep(2);
                throw new IllegalStateException("s");
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            //System.out.println("I'll run in a separate thread than the main thread.");
        });

        // Block and wait for the future to complete
       // future.join();
        future.thenApply(res -> {
            if (res == null) {
                System.out.println("asd");
            } else {
                System.out.println("asdddd");
            }
            return null;
        });


        // Here’s how you can create a thread pool and pass it to one of these methods -
//        Executor executor = Executors.newFixedThreadPool(10);
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new IllegalStateException(e);
//            }
//            return "Result of the asynchronous computation";
//        }, executor);
//
//        System.out.println(future1.join());
//
//
//        //================================================================================================
//        // Run a task specified by a Supplier object asynchronously
//        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new IllegalStateException(e);
//            }
//            return "Result of the asynchronous computation";
//        });
//
//        // Block and get the result of the Future
//        String result2 = future2.get();
//        System.out.println(result2);
    }

//    You might be wondering that - Well, I know that the runAsync() and supplyAsync() methods execute their tasks in a separate thread. But, we never created a thread right?
//
//    Yes! CompletableFuture executes these tasks in a thread obtained from the global ForkJoinPool.commonPool().
//
//    But hey, you can also create a Thread Pool and pass it to runAsync() and supplyAsync() methods to let them execute their tasks in a thread obtained from your thread pool.
//
//    All the methods in the CompletableFuture API has two variants - One which accepts an Executor as an argument and one which doesn’t -
//
//    // Variations of runAsync() and supplyAsync() methods
//    static CompletableFuture<Void>	runAsync(Runnable runnable)
//    static CompletableFuture<Void>	runAsync(Runnable runnable, Executor executor)
//    static <U> CompletableFuture<U>	supplyAsync(Supplier<U> supplier)
//    static <U> CompletableFuture<U>	supplyAsync(Supplier<U> supplier, Executor executor)

}

class CFThenApply {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create a CompletableFuture
        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        });

// Attach a callback to the Future using thenApply()
        CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
            return "Hello " + name;
        });

// Block and get the result of the future.
        System.out.println(greetingFuture.get()); // Hello Rajeev

//------------------------------------------------------------------------------------------------------------
//You can also write a sequence of transformations on the CompletableFuture by attaching a series of thenApply()
// callback methods. The result of one thenApply() method is passed to the next in the series -
        CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        }).thenApply(name -> {
            return "Hello " + name;
        }).thenApply(greeting -> {
            return greeting + ", Welcome to the CalliCoder Blog";
        });

        System.out.println(welcomeText.get());
// Prints - Hello Rajeev, Welcome to the CalliCoder Blog
    }


}
