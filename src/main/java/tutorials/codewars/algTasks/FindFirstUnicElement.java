package tutorials.codewars.algTasks;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindFirstUnicElement {

    public static void main(String[] args) {
        int[] arr = {9, 4, 9, 6, 7, 4, 5};
        System.out.println(findFirstUniqueInt(arr));
    }

    // Найти первый не повторяющийся элемент в массиве целых чисел
    public static int findFirstUniqueInt(int[] arr) {
        Set<Integer> input = new LinkedHashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int x : arr) {
            if (!input.add(x)) {
                duplicates.add(x);
            }
        }
        input.removeAll(duplicates);
        return input.isEmpty() ? null : input.iterator().next();

    }

}
