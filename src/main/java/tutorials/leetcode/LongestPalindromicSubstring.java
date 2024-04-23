package tutorials.leetcode;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "ad";
        System.out.println(fun(s));
    }

    public static char[] fun(String s) {
        char[] result = new char[0];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            for (int j = i + 1; j < charArray.length; j++) {
                char c1 = charArray[j];
                if (c == c1) {
                    result = Arrays.copyOfRange(charArray, i, j + 1);
                    if (isPolim(result, i, j)) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static boolean isPolim(char[] charArray, int i, int j) {
        if (i + j == 0){
            return true;
        }
        if (charArray[i] == charArray[j]) {
            isPolim(Arrays.copyOfRange(charArray,i+1,j),i+1,i-1);
            return true;
        }
        return false;
    }
}
