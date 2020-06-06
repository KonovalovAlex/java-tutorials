package tutorials.doubleCheckProblem;

public class Main {
    Singleton singleton = new Singleton().getInstance();

    static class Singleton {
        //добавить volatile что бы решить проблему double check
        //операции будут последовательны!
        private static Singleton singleton;

        private Singleton() {
        }
        public static Singleton getInstance() {
            if (singleton == null) {
                //synchronized не гарантирует что операции внутри потока(метода) будут выполяться последовательно!
                // volatile - гарантирует что операции будут последовательны!!
                //в переменную singleton сперва может записаться null, а потом она может проинициализироваться
                //то есть вернётся null
                synchronized (Singleton.class) {
                    if (singleton == null) {
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }
}
