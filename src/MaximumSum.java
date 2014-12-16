/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 10/30/14
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 * https://oj.leetcode.com/problems/maximum-subarray/
 */
public class MaximumSum {

  public static int maximumSum(int[] A) {

    int maxSum = Integer.MIN_VALUE;
    int runningSum = 0;
    for (int i =0; i< A.length; i++) {
      runningSum += A[i];
      maxSum = Math.max(maxSum, runningSum);
      if (runningSum < 0) {
        runningSum = 0;
      }
    }
    return maxSum;
  }

  public static void main(String args[]) {
    int[] A = {1, -2, 4, 2, -2, 3};
    System.out.println(maximumSum(A));
    assert maximumSum(A) == 7;
    int[] A2 = {-1, -2, -3, -4};
    System.out.println(maximumSum(A2));
    assert maximumSum(A2) == 7;
  }
}
