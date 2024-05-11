package tutorials.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(toInteger());

    }

    public static int toInteger() {
       // char[] s = "MCMXCIV".toCharArray();1994
        char[] s = "LVIII".toCharArray(); //58
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int value = 0;
        for (int i = 0, previous = 0; i < s.length; i++) {
            char c = s[i];
            Integer i1 = map.get(Character.toString(c));

            if (previous < i1) {
                value = value + (i1 - (previous * 2));
            } else {
                value += i1;
            }
            previous = i1;
        }

        return value;
    }
}
