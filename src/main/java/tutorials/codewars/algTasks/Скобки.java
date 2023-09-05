package tutorials.codewars.algTasks;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Скобки {
    public static void main(String[] args) {


    }

    public static boolean test(String args) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (char s : args.toCharArray()) {
            if (map.containsValue(s)) {
                stack.push(s);
            } else if (map.containsKey(s)) {
                if (stack.isEmpty() || stack.pop() != map.get(s)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//        An input string is valid if:
//        Open brackets must be closed by the same type of brackets.  （]
//        Open brackets must be closed in the correct order.  )(
//        Every close bracket has a corresponding open bracket of the same type.
//        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
//        Example 1:
//        Input: s = "()"
//        Output: true
//        ~~~~~~~~~~~~~~~
//        Example 2:
//        Input: s = "()[]{}"
//        Output: true
//        ~~~~~~~~~~~~~~~
//        Example 3:
//        Input: s = "(]"
//        Output: false
//        ~~~~~~~~~~~~~~~
//        Example 4:
//        Input: s = "(())"
//        Output:true
//        ~~~~~~~~~~~~~~~
//        Example 5:
//        Input: s = "([)]"
//        Output:false
//
//        Stack
