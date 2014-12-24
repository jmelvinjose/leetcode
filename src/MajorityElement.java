/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/24/14
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 * https://oj.leetcode.com/problems/majority-element/
 */
public class MajorityElement {

  public int majorityElement(int[] num) {
    int counter = 0;
    int current = -1;

    for (int i = 0; i < num.length; i++) {
      if (counter == 0) {
        current = num[i];
        counter++;
      } else {
        if (current == num[i]) {
          counter++;
        } else {
          counter--;
        }
      }
    }
    return current;
  }

  public static void main(String args[]) {
    MajorityElement m = new MajorityElement();

    int[] test = {1, 2, 1, 3, 1};
    System.out.println(m.majorityElement(test));
  }
}
