package tutorials.leetcode;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "sadbutsadggsad", needle = "sad";
        strStr(haystack, needle);

    }

    private static int strStr(String s, String input) {
        char[] haystack = s.toCharArray();
        char[] needle = input.toCharArray();
        for (int i = 0; i < haystack.length; i++) {
            char c = haystack[i];
            if (needle[0] == c) {
                for (int j = 1, i2=i+1; j < needle.length; j++, i2++) {
                    char needleChar = needle[j];
                    char haystackChar = haystack[i2];
                    if (needleChar!=haystackChar){
                        break;
                    } else if (j==needle.length-1){
                        System.out.println(i);
                    }
                }
            }
        }
        return -1;
    }
}
