package leetcode121_BestTimeToBuyAndSellStock;

class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 0 || prices.length == 1) return 0;

    int lowestPrice = prices[0];

    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] - lowestPrice > maxProfit) {
        maxProfit = prices[i] - lowestPrice;
      }

      lowestPrice = Math.min(lowestPrice, prices[i]);
    }

    return maxProfit < 0 ? 0 : maxProfit;
  }
}
