package tutorials.leetcode;

public class _121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        maxProfit(array);
    }

    public static int maxProfit(int[] prices) {
        int ans = 0, mi = prices[0];
        for (int v : prices) {
            ans = Math.max(ans, v - mi);
            mi = Math.min(mi, v);
        }
        return ans;
    }

}
