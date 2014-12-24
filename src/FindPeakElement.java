/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/24/14
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 * https://oj.leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {

  public int findPeakElement(int[] num) {

    if (num.length == 0) {
      return 0;
    }

    int peak = 0, peakIndex = 0;
    int prevIndex = 0, nextIndex = 0, prev = 0, next = 0;
    for (int i = 0; i < num.length; i++) {
      prevIndex = i - 1;
      nextIndex = i + 1;
      if (!(prevIndex >= 0 && prevIndex < num.length)) {
        prev = Integer.MIN_VALUE;
      } else {
        prev = num[prevIndex];
      }
      if (!(nextIndex >= 0 && nextIndex < num.length)) {
        next = Integer.MIN_VALUE;
      } else {
        next = num[nextIndex];
      }
      if (num[i] > prev && num[i] > next) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String args[]) {
    FindPeakElement f = new FindPeakElement();
    int[] test = {1};
    System.out.println(f.findPeakElement(test));
  }
}
