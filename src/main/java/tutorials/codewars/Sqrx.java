package tutorials.codewars;

public class Sqrx {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.mySqrt(16);
    }
    static class Solution {
        public int mySqrt(int x) {
            return (int) Math.sqrt(x);
        }
    }
}


