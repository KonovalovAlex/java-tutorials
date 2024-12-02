package tutorials.leetcode;

import java.util.Arrays;

public class _088MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        for (int j = 0, i = m; j < n; j++, i++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }
}
