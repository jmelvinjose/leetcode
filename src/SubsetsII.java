import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/15/14
 * Time: 7:53 AM
 * To change this template use File | Settings | File Templates.
 *
 * https://oj.leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {

  private Set<List<Integer>> subSets;

  public List<List<Integer>> subsetsWithDup(int[] num) {

    subSets = new HashSet<List<Integer>>();

    int n = num.length;
    Arrays.sort(num);

    for (long i = 0; i < (1 << n); i++ ) {

      List<Integer> element = new ArrayList<Integer>();

      for (int j =0; j < n; j++) {
        if (((i >> j) %2) == 1) {
          element.add(num[j]);
        }
      }
      subSets.add(element);
    }
    return new ArrayList<List<Integer>>(subSets);
  }

  public static void main(String args[]) {

    SubsetsII s = new SubsetsII();

    int[] test = {1, 2, 2};

    System.out.println(s.subsetsWithDup(test));
  }
}
