package tutorials.leetcode;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("abb","..."));
    }
    public static boolean isMatch(String s, String p) {
        //осталось добавить когда длина разная
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (pArray[i]== '*') {
                return true;
            }

            if (sArray[i]== pArray[i] || pArray[i]== '.'){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
