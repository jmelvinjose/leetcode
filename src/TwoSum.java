import util.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/24/14
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 * https://oj.leetcode.com/problems/two-sum/
 */
public class TwoSum {

  public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < numbers.length; i++) {
      map.put(numbers[i], i);
    }
    // second traversal
    for (int i = 0; i < numbers.length; i++) {
      if (map.containsKey(target - numbers[i]) && map.get(target - numbers[i]) != i) {
        int index1 = map.get(target - numbers[i])+1;
        int index2 = i+1;
        if (index1 < index2) {
          result[0] = index1;
          result[1] = index2;
        } else {
          result[0] = index2;
          result[1] = index1;
        }
        return result;
      }
    }
    return result;
  }

  public static void main(String args[]) {
    TwoSum t = new TwoSum();
    int[] test = {3, 2, 4};
    int target = 6;
    int[] result = t.twoSum(test, target);
    PrintUtils.printArray(result);
  }
}
