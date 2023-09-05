package tutorials.codewars;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] i = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(i));


    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int max_profit = 0;

        for(int i : prices){
            int profit = i - buy;
            if(profit > max_profit){
                max_profit = profit;
            }
            if(buy > i){
                buy = i;
            }
        }
        return max_profit;
    }
}
