package tutorials.leetcode;

public class _055JumpGame {
    public static void main(String[] args) {
        int[] array = {3,2,1,0,4};
        System.out.println(jump(array));
    }

    private static boolean jump(int[] array){
        for (int i = 0; i < array.length; ) {
            int value = array[i];
            if (value==0) return false;
            if (i == array.length-1){
                return true;
            }
            i += value;
        }
        return false;
    }

}
