package tutorials.leetcode;

public class SearchInRotatedSortedArray {
//    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        search(nums, 2);
//        int[] test = test(nums);
//        Arrays.stream(test).forEach(System.out::println);
//    }

    public static void main(String[] args) {
        int [] array = {1};
        Integer i2 = 2;
        swap(array, i2);
        System.out.println(array[0]+ i2);
    }

    private static void swap(int[] i1, Integer i2) {
        i1[0] = 3;
        i2 = 4;
    }


    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = (right - left) / 2;

        return 0;
    }

    public static int[] test(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int index = -1;

            if (array[i] == 0) {
                if (index < 0) {
                    index = i;
                }
                continue;
            } else {
                if (index >= 0) {
                    array[index] = array[i];
                    array[i] = 0;
                    index++;
                    continue;
                }
            }

        }
        return array;
    }

}
