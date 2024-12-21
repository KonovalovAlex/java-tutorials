package tutorials.leetcode;

public class _209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int[] nums1 = {2,3,1,2,4,3};
        int i = minSubArrayLen(4, nums);
        //int i1 = minSubArrayLen(7, nums1);
        System.out.println(i);
        //System.out.println(i1);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= target) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
