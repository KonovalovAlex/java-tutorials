package tutorials.leetcode;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        search(nums, 2);
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length -1;
        int mid = (right-left) / 2;



        return 0;
    }
}
