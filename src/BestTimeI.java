/**
 * Created by melvinj on 2/9/15.
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeI {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < prices.length; i++) {
      min = Math.min(min, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - min);
    }
    return maxProfit;
  }
}
