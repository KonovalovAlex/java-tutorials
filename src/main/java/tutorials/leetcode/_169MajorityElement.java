package tutorials.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _169MajorityElement {
    public static void main(String[] args) {
        int[] array = {2, 2, 1, 1, 1, 2, 2};
        majorityElement(array);
    }

    public static ArrayList<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> countValueMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums) {
            countValueMap.merge(num, 1, Integer::sum);
            if (countValueMap.get(num) > length / 2) {
                result.add(countValueMap.get(num));
            }
        }
        return result;
    }
}
