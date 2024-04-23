package tutorials.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1555));

    }
    public static int reverse(int value){
        int ans = 0;
        for (; value != 0; value /= 10) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + value % 10;
        }
        return ans;
    }
}
