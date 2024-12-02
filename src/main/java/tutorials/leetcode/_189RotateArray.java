package tutorials.leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.rotate;

public class _189RotateArray {
    static int[] nums = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        List<Integer> intList = getIntegers(array, k);
        int last = array.length-1;
        reverseIntegersFromIndex(array, last);
        reverseIntegersFromIndex(array, k);
        reverseIntegersFromIndex(array, last);
        System.out.println(array);
    }

    private static void reverseIntegersFromIndex(int[] array, int k) {
        for (int i = 0; i < k; i++, k--) {
            int t = array[i];
            array[i] = array[k];
            array[k] = t;
        }
    }

    private static @NotNull List<Integer> getIntegers(int[] array, int k) {
        List<Integer> intList = new ArrayList<>(array.length);
        for (int j : array) {
            intList.add(j);
        }
        rotate(intList, k);
        return intList;
    }
}
