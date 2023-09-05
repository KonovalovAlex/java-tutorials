package tutorials.multithreading.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExeTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //------------------------------------------------------------------------------------------------------------
        //не возвращает
        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //------------------------------------------------------------------------------------------------------------
        //возвращает
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };
        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        //------------------------------------------------------------------------------------------------------------
        //invokeAny() присваивает набор задач ExecutorService , вызывая выполнение каждой из них,
        // и возвращает результат успешного выполнения одной задачи (если было успешное выполнение)
        String result = executorService.invokeAny(callableTasks);
        System.out.println(result);

        //------------------------------------------------------------------------------------------------------------
        //submit() отправляет задачу Callable или Runnable в ExecutorService и возвращает результат типа Future :
        Future<String> future =
                executorService.submit(callableTask);

        //------------------------------------------------------------------------------------------------------------
        //invokeAll() присваивает ExecutorService набор задач , вызывая выполнение каждой из них,
        // и возвращает результат выполнения всех задач в виде списка объектов типа Future :
        List<Future<String>> futures = executorService.invokeAll(callableTasks);
        System.out.println(futures);

        //------------------------------------------------------------------------------------------------------------
        executorService.shutdown();
        //Метод shutdownNow() пытается немедленно уничтожить ExecutorService , но не гарантирует,
        // что все запущенные потоки будут остановлены одновременно

        //------------------------------------------------------------------------------------------------------------
        //При таком подходе ExecutorService сначала перестанет принимать новые задачи,
        // а затем будет ждать до указанного периода времени, пока все задачи будут выполнены.
        // Если это время истекает, выполнение немедленно останавливается.
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        //------------------------------------------------------------------------------------------------------------
        //Если период выполнения больше указанного (в данном случае 200 миллисекунд), будет выдано исключение TimeoutException
        try {
            String result1 = future.get(200, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }


        //------------------------------------------------------------------------------------------------------------
        //Интерфейс Future также предусматривает отмену выполнения задачи с помощью метода cancel() и проверку отмены
        // с помощью метода isCancelled() :
        boolean canceled = future.cancel(true);
        boolean isCancelled = future.isCancelled();
    }
}
