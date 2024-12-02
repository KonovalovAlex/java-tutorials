//package tutorials.tutorials;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//public class Conc {
//    public static void main(String[] args) throws InterruptedException {
//        /*
//            Каждый кошелек характеризуется одним интом - балансом.
//            Изначально создаем список из 10 кошельков, на каждом из которых баланс равен 100.
//        */
//        List<Wallet> wallets = new ArrayList<>();
//        for (int i = 0; i < 10; ++i) {
//            wallets.add(new Wallet(100));
//        }
//        ExecutorService executor = Executors.newFixedThreadPool(100);
//        for (int i = 0; i < 100000; ++i) {
//            /*
//                Переводим все деньги с одного кошелька на другой.
//                Для каждого перевода выбираются последовательные кошельки:
//                из 1 всегда переводим во 2, из 2 всегда переводим в 3 и т.д.
//                Из последнего кошелька всегда переводим в первый.
//            */
//            Wallet wallet1 = wallets.get(i % wallets.size());
//            Wallet wallet2 = wallets.get((i + 1) % wallets.size());
//            executor.execute(() -> transfer(wallet1, wallet2));
//        }
//        executor.shutdown(); // не отменяет уже засабмиченные таски
//        executor.awaitTermination(1, TimeUnit.DAYS); // дожидается исполнения всех засабмиченных тасок
//        /*
//            Здесь считаем сумму балансов всех кошельков и выводим её.
//            Если бы предыдущего цикла не было, то ожидается, что выведется 1000
//            (потому что изначально было 10 кошельков по 100 монет).
//        */
//        int sum = wallets.stream().mapToInt(wallet -> wallet.balance.get()).sum();
//        System.out.println(sum);
//    }
//
//    private static void transfer(Wallet wallet1, Wallet wallet2) {
//        wallet2.balance.addAndGet(wallet1.balance.get());
//        wallet1.balance.set(0);
//    }
//}
//
//        private static class Wallet {
//            public final AtomicInteger balance;
//
//            public Wallet(int initialBalance) {
//                balance = new AtomicInteger(initialBalance);
//            }
//        }
//    }
//            }
