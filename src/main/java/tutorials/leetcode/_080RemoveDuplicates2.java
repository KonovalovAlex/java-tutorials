package tutorials.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _080RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] mas = {0, 0, 1, 1, 1, 1, 2, 3, 3};

        removeDuplicates2(mas);

    }

    public static int[] removeDuplicates(int[] nums) {
        Map<Integer, Integer> indexCounter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (indexCounter.get(number) != null && indexCounter.get(number) >= 2) {
                nums[i] = 42;
            }
            indexCounter.merge(number,1, Integer::sum);
        }
        return Arrays.stream(nums).sorted().toArray();
    }

    public static int removeDuplicates2(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
