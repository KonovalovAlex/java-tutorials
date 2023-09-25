package tutorials.tutorials.multithreading.executorService

import java.util.*
import java.util.concurrent.*

class Exe {
    //@kotlin.Throws(ExecutionException::class, InterruptedException::class)
    fun main() {
        val executorService = Executors.newSingleThreadExecutor()
        //------------------------------------------------------------------------------------------------------------
        //не возвращает
        val runnableTask = Runnable {
            try {
                TimeUnit.MILLISECONDS.sleep(2200)
                println("task1")
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

        //------------------------------------------------------------------------------------------------------------
        //возвращает
        val callableTask = Callable {
            TimeUnit.MILLISECONDS.sleep(300)
            "Task's execution"
        }
        val callableTasks: MutableList<Callable<String>> = ArrayList()
        callableTasks.add(callableTask)
        callableTasks.add(callableTask)
        callableTasks.add(callableTask)

        //------------------------------------------------------------------------------------------------------------
        //invokeAny() присваивает набор задач ExecutorService , вызывая выполнение каждой из них,
        // и возвращает результат успешного выполнения одной задачи (если было успешное выполнение)
        val result = executorService.invokeAny(callableTasks)
        System.out.println(result)

        //------------------------------------------------------------------------------------------------------------
        //submit() отправляет задачу Callable или Runnable в ExecutorService и возвращает результат типа Future :
        val future = executorService.submit(callableTask)

        //------------------------------------------------------------------------------------------------------------
        //invokeAll() присваивает ExecutorService набор задач , вызывая выполнение каждой из них,
        // и возвращает результат выполнения всех задач в виде списка объектов типа Future :
        val futures = executorService.invokeAll(callableTasks)
        System.out.println(futures)

        //------------------------------------------------------------------------------------------------------------
        executorService.shutdown()
        //Метод shutdownNow() пытается немедленно уничтожить ExecutorService , но не гарантирует,
        // что все запущенные потоки будут остановлены одновременно

        //------------------------------------------------------------------------------------------------------------
        //При таком подходе ExecutorService сначала перестанет принимать новые задачи,
        // а затем будет ждать до указанного периода времени, пока все задачи будут выполнены.
        // Если это время истекает, выполнение немедленно останавливается.
        executorService.shutdown()
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow()
            }
        } catch (e: InterruptedException) {
            executorService.shutdownNow()
        }

        //------------------------------------------------------------------------------------------------------------
        //Если период выполнения больше указанного (в данном случае 200 миллисекунд), будет выдано исключение TimeoutException
        try {
            val result1 = future[200, TimeUnit.MILLISECONDS]
        } catch (e: TimeoutException) {
            throw RuntimeException(e)
        }


        //------------------------------------------------------------------------------------------------------------
        //Интерфейс Future также предусматривает отмену выполнения задачи с помощью метода cancel() и проверку отмены
        // с помощью метода isCancelled() :
        val canceled = future.cancel(true)
        val isCancelled = future.isCancelled
    }
}