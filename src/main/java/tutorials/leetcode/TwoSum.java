package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 13)));
    }

    public static int[] twoSum(int[] nums, int target){
        int[] ans = new int[2];

        // number and it's corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {

            if (!map.containsKey(nums[index])) {

                map.put(target - nums[index], index);

            } else {
                ans[0] = index;
                ans[1] = map.get(nums[index]);
                break;
            }
        }
        return ans;
    }
}
