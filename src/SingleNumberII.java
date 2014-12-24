/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/24/14
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 * https://oj.leetcode.com/problems/single-number-ii/
 */
public class SingleNumberII {

  public int singleNumber(int[] A) {
    int ec1 = 0, ec2 = 0, ec3 = 0;

    for (int i = 0; i < A.length; i++) {
      int val = A[i];
      ec3 = ec2 & val;
      ec2 = (ec2 | (ec1 & val)) & (~ec3);
      ec1 = (ec1 | val) & (~ec3);
    }
    return ec1;
  }

}
