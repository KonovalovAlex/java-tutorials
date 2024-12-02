package tutorials.leetcode;

public class _122BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        maxProfit(array);
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

}
