package tutorials.multithreading.threadLocal;

public class ThrLocal {

    //для каждого потока будет своё значение(можем класть объекты)
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("hello");
        Thread one = new ThreadOne();
        Thread two = new ThreadTwo();
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println("main"+threadLocal.get());
    }

    static class ThreadOne extends Thread {
        public void run() {
            threadLocal.set("ThreadOne");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }
    }
    static class ThreadTwo extends Thread {
        public void run() {
            threadLocal.set("ThreadTwo");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }
    }
}
