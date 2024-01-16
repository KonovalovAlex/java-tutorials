package tutorials.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {
    //You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning,
    // you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following
    // conditions are fulfilled:
    //i + minJump <= j <= min(i + maxJump, s.length - 1), and
    //s[j] == '0'.
    //Return true if you can reach index s.length - 1 in s, or false otherwise.

    public static void main(String[] args) {
        canReach("01101110",4,3);
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length() - 1) != '0')
            return false;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);

        while(!queue.isEmpty()){
            int idx = queue.remove();
            if(idx == s.length() - 1)
                return true;
            for(int i = idx + minJump; i <= idx + maxJump && i < s.length(); i++){
                if(!visited[i] && s.charAt(i) == '0'){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return false;
    }
}
