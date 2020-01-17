# Leetcode

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

```
Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.



```

# Solution

1. 如果不从dp的角度来思考的话, 就是需要维护一个之前最低价格和目前最大的值. 然后遍历一遍就可以解决问题.
2. 从dp的考虑的话, 需要把问题转化求差数组的最大子序和
因为两个元素的最大差等于求差数组的最大子序和;

```
比如说:
[1,2,3,4,5,6]
diff[] = [1,1,1,1,1];
最大就是1+1+1+1+1; 也就是6 -1;
```




```java
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

```
