package tutorials.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MassiveWithNumbers {
    /**
     * Дана последовательность целых чисел. Необходимо найти минимально возможное произведение пары элементов последовательности.
     * Например, для последовательности чисел 9 4 2 5 3 ответ будет 6.
     * -3-1 9 4 2 5 3
     * -2
     * -9
     * <p>
     * -1 -2 -3 -4
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-9, 4, 2, 5, 3);
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
            if (collect.get(0)>0){
                int i = collect.get(0) * collect.get(1);
                System.out.println(i);
            }
            if (collect.get(0)<0){
                int i = collect.get(0) * collect.get(collect.size() - 1);
                System.out.println(i);
            }

        }



    public static class Test {
        public static void main(String[] args) {
            System.out.println(function("h", "hhhhhello"));
        }

        private static int function(String charr, String word) {
            int result = 1;
            int indexChar = word.indexOf(charr);
            if (indexChar >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    String substringLeft;
                    if (indexChar == 0) {
                        substringLeft = "";
                    } else {
                        substringLeft = word.substring(0, indexChar);
                    }
                    String substringRight = word.substring(indexChar + 1);
                    word = substringLeft.concat(substringRight);
                    result = result + function(charr, word);
                    return result;
                }
            }
            return 0;
        }
    }
}
