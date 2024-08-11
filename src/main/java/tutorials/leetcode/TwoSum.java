package tutorials.leetcode;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 22, 4, 12, 13, 16, 17};
        System.out.println(Arrays.toString(twoSum(nums, 32)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return new int[]{map.get(num), num};
            } else {
                map.put(target - num, num);
            }
        }
        return null;
    }
}
