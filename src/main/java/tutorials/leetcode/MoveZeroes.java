package tutorials.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeroes {

    ///моё решение
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        if (nums.length == 1 && nums[0] == 0) {
            System.out.println(Arrays.toString(nums));
        }
        //int[] result = reversEnumeration(nums.length - 1, nums.length - 2, nums);
        //System.out.println(Arrays.toString(result));

        someSolution(nums);
    }

    public static int[] reversEnumeration(int lastIndex, int previousIndex, int[] nums) {
        if (previousIndex == 0 && nums[previousIndex] != 0) return nums;
        if (previousIndex >= nums.length - 1) return nums;

        if (nums[previousIndex] == 0) {
            int lastValue = nums[lastIndex];
            int previousValue = nums[previousIndex];
            nums[lastIndex] = previousValue;
            nums[previousIndex] = lastValue;
            if (lastIndex >= nums.length - 1) {
                reversEnumeration(lastIndex - 1, previousIndex - 1, nums);
            }
            return reversEnumeration(lastIndex + 1, previousIndex + 1, nums);
        } else {
            reversEnumeration(lastIndex - 1, previousIndex - 1, nums);
        }

        return nums;
    }



    public static void someSolution(int[] nums) {

        //BRUTE FORCE APPROACH**
//        int n = nums.length;
//        List<Integer> temp = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != 0) {
//                temp.add(nums[i]);
//            }
//        }
//        int m = temp.size();
//        for (int i = 0; i < m; i++) {
//            nums[i] = temp.get(i);
//        }
//        for (int i = m; i < n; i++) {
//            nums[i] = 0;
//        }

        //THE OPTIMAL SOLUTION**

        int i = 0;
        int n = nums.length;
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }
        while (i < n) {
            nums[i] = 0;
            i++;
        }
    }

}

