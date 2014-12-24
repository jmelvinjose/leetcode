/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/24/14
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 * https://oj.leetcode.com/problems/single-number/
 */
public class SingleNumber {

  public int singleNumber(int[] A) {

    int ans =0;
    for(int i=0; i<A.length; i++) {
      ans = ans ^ A[i];
    }
    return ans;
  }
}
