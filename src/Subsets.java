import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/15/14
 * Time: 7:26 AM
 * To change this template use File | Settings | File Templates.
 *
 * https://oj.leetcode.com/problems/subsets/
 *
 */
public class Subsets {

  private List<List<Integer>> subSets;

  public List<List<Integer>> subsets(int[] S) {
    subSets = new ArrayList<List<Integer>>();
    int n = S.length;
    Arrays.sort(S);

    for (long i = 0; i < (1 << n); i++ ) {

      List<Integer> element = new ArrayList<Integer>();

      for (int j =0; j < n; j++) {
        if (((i >> j) %2) == 1) {
          element.add(S[j]);
        }
      }
      subSets.add(element);
    }
    return subSets;
  }

  public static void main(String args[]) {

    Subsets s = new Subsets();

    int[] test = {1, 2, 3};

    System.out.println(s.subsets(test));
  }
}
