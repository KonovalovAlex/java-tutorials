package tutorials.multithreading.phaser;

public class SynchronizedExample {

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();

    }

}

class Sync {
    public synchronized void foo() {
        for (int i = 0; i < 2000; i++) {
            System.out.println("thr 1 " + Thread.currentThread().getName() + " i " + i);
        }
    }

    public synchronized void bar() {
        for (int i = 0; i < 2000; i++) {
            System.out.println("thr 2 " + Thread.currentThread().getName() + " i " + i);
        }
    }
}

//не синхронизовано
class MyThread extends Thread {
    Sync sync = new Sync();

    @Override
    public void run() {
        sync.foo();
        sync.bar();
    }
}


