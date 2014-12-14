import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 10/30/14
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Permutations {

  static List<List<Integer>> result;

  public static void permuteHelper(int[] num, int n) {

    if (n == 1) {
      List<Integer> temp =  new ArrayList<Integer>();
      for (int i=0; i<num.length; i++) {
        temp.add(num[i]);
      }
      result.add(temp);
    }

    for (int i =0; i<n; i++) {
      if (shouldSwap(num, i)) {
        swap(num, i, n-1);
        permuteHelper(num, n-1);
        swap(num, i, n-1);
      }
    }
  }

  public static boolean shouldSwap(int[] num, int start) {
    for (int i=0; i< start; i++) {
      if (num[i] == num[start]) {
        return false;
      }
    }
    return true;
  }

  public static void swap(int[] num, int i, int j) {
    int t = num[i];
    num[i] = num[j];
    num[j] = t;
  }

  public static List<List<Integer>> permute(int[] num) {
    result = new ArrayList<List<Integer>>();
    permuteHelper(num, num.length);
    return result;
  }

  public static void main(String args[]) {
    int[] test = {1,1,2};
    List<List<Integer>> res = permute(test);
    System.out.println(res.toString());
  }
}
