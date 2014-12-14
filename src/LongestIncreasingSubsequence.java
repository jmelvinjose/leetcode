/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 11/2/14
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestIncreasingSubsequence {
  static int[] dp;
  static int[] A;

  public static int solve(int index) {
    if (index == A.length-1)
      return 1;

    int res = dp[index];
    if (res != -1) {
      return res;
    }
    res = 0;
    for (int i = index+1; i < A.length; i++) {
      if (A[i] > A[index]) {
        res = Math.max(res, 1 + solve(i));
      }
    }
    res = Math.max(res, solve(index+1));
    dp[index] = res;
    return res;
  }

  public static int longest(int[] a) {
    A = a;
    dp = new int[a.length];
    for (int i=0; i< a.length; i++) {
      dp[i] = -1;
    }
    return solve(0);
  }

  public static void main(String args[]) {
    int[] test = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
    System.out.println(longest(test));
    int[] test1 = {8, 4, 5, 6};
    System.out.println(longest(test1));
  }
}
