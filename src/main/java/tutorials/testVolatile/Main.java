package tutorials.testVolatile;

public class Main {
    //переменная закешируется и потом read зависнет потому что у него в кеше i будет всегда 0
    //решение - поставить volatile что бы переменная сохранялась в озу
    //если одну переменную сделать volatile, то и другию станут volatile!
    static int i;
    volatile static int f;

    public static void main(String[] args) {
        new Write().start();
        new Read().start();
        new Writef().start();
        new Readf().start();
        System.out.println(i);
    }

    static class Write extends Thread {
        @Override
        public void run() {
            while (i < 50)
                System.out.println("increace i" + (++i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Read extends Thread {
        @Override
        public void run() {
            int localValue = i;
            while (localValue < 50)
                if (localValue != i)
                    System.out.println(localValue = i);
        }
    }

    static class Writef extends Thread {
        @Override
        public void run() {
            while (f < 50)
                System.out.println("increace i" + (++f));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Readf extends Thread {
        @Override
        public void run() {
            int localValue = f;
            while (localValue < 50)
                if (localValue != f)
                    System.out.println(localValue = f);
        }
    }
}
