package tutorials.leetcode;

import javax.swing.*;

public class _58LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        String[] split = s.split("\\s+");
        String last = split[split.length - 1];
        int letterCount = 0;

        for (char c : last.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount++;
            }
        }
        System.out.println(letterCount);
    }
}
