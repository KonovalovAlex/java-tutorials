package tutorials.leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String s1 = "caaabbbaaa";
        System.out.println(findPalindromic(s1));
    }

    public static char[] findPalindromic(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            Pair palindromic = isPalindromic(i, charArray);
            if (palindromic != null) {
                System.out.println(palindromic.start);
                System.out.println(palindromic.end);
            }

        }
        return charArray;
    }

    private static Pair isPalindromic(int start, char[] charArray) {
        int from = start;
        int to = 0;
        for (int j = charArray.length; start<j;) {
            char end = charArray[j-1];
            if (charArray[start] == end) {
                to++;
                j = j-1;
                start = start+1;
                if (start==j || start+1==j){
                    return new Pair(from, start+j-1);
                }
            } else {
                j = j-1;
            }
        }
        return null;
    }
} class Pair {
    int start, end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
