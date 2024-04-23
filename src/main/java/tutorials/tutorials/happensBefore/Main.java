package tutorials.tutorials.happensBefore;

public class Main {
    static int a;
    static int b;

    public static void main(String[] args) {
        new Thread(() -> {
            // переменные r1 и b  могут поменяться местами! внутри этого потока
            // volatile гарантирует что порядок будет соблюдаться
            // то есть сначала будет обработана переменная r1 потом b
            int r1 = a;
            b = 2;
        }).start();
        new Thread(() -> {
            int r2 = b;
            a = 1;
        }).start();
    }
}
