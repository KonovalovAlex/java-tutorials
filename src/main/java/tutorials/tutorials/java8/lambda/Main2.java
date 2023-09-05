package tutorials.java8.lambda;

import java.util.Comparator;

import static java.lang.Thread.sleep;

public class Main2 {
    public static void main(String[] args) throws Exception {
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(1,1));
        System.out.println();
    }
}
