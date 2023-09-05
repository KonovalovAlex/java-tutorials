package tutorials.java8.lambda.capturing;

import java.math.BigDecimal;
import java.util.function.Function;

public class Main {

    public class LambdaInstanceCapturing implements Runnable {

        private BigDecimal bd = new BigDecimal(1);

        @Override
        public void run() {
            Function<BigDecimal, BigDecimal> func = (a) -> bd.multiply(a);

            for (int j = 0; j < 999999999; j++) {
                func.apply(new BigDecimal(j));
            }
        }

        public class NonLambdaInstanceCapturing implements Runnable {

            @Override
            public void run() {
                Function<BigDecimal, BigDecimal> func = (a) -> a.multiply(BigDecimal.TEN);

                for (int j = 0; j < 999999999; j++) {
                    func.apply(new BigDecimal(j));
                }
            }

        }
    }
}
