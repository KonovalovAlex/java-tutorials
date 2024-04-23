package tutorials.leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(palindromeNumber(123321));

    }

    public static boolean palindromeNumber(int x){
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int y = 0;
        for (; y < x; x /= 10) {
            y = y * 10 + x % 10;
        }
        return x == y || x == y / 10;
    }
}
