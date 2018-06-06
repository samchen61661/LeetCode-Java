class Solution {
    public int maxProfit(int[] prices, int fee) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for (int price : prices) {
            min = Math.min(min, price - profit + fee);
            profit = Math.max(profit, price - min);
        }
        
        return profit;
    }
}
