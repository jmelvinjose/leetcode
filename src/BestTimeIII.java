/**
 * Created by melvinj on 2/9/15.
 */
public class BestTimeIII {

  int[] dp;

  public int maxProfit(int[] prices) {
    int n = prices.length;

    if (n == 0 || n == 1) {
      return 0;
    }

    dp = new int[n];
    dp[n-1] = 0;

    int maxStock = prices[n-1];

    for (int i = n - 2; i >=0; i--) {
      int current = prices[i];
      dp[i] = dp[i+1];
      dp[i] = Math.max(dp[i], maxStock - current);
      maxStock = Math.max(maxStock, current);
    }

    int res = 0;
    int minStock = prices[0];

    for (int i = 1; i < prices.length; i++) {
      res = Math.max(res, (prices[i] - minStock) + dp[i]);
      minStock = Math.min(minStock, prices[i]);
    }
    return res;
  }
}
