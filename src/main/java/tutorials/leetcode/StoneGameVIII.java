package tutorials.leetcode;

public class StoneGameVIII {
    public static void main(String[] args) {
        int[] stones = {-1,2,-3,4,-5};
        stoneGameVIII(stones);
    }
    public static int stoneGameVIII(int[] stones){

        int n = stones.length;
        int[] prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + stones[i];
        }
        int[] dp = new int[n];
        dp[n-1] = prefix[n-1];
        for (int i = n-2; i >= 0; i--) {
            dp[i] = Math.max(prefix[i] - dp[i+1], dp[i+1]);
        }
        return dp[1];
    }
}
