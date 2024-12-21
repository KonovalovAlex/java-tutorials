package tutorials.leetcode;

import java.util.Arrays;

public class _238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
        //попробовать через хэш мапу
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Вычисляем "левые произведения"
        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        // Вычисляем "правые произведения" и объединяем с результатом
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }
}
