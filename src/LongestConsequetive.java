import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 11/3/14
 * Time: 8:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class LongestConsequetive {

  static Set<Integer> set;

  public static int longestConsecutive(int[] num) {
    set = new HashSet<Integer>();
    if (num.length <=0)
      return 0;
    for (int i =0; i< num.length; i++) {
      set.add(num[i]);
    }
    int res = 1;
    for (int i =0; i < num.length; i++) {
      int left = num[i] -1;
      int right = num[i] + 1;
      int count = 1;
      while(set.contains(left)) {
        count++;
        set.remove(left);
        left--;
      }
      while (set.contains(right)) {
        count++;
        set.remove(right);
        right++;
      }
      res = Math.max(res, count);
    }
    return res;
  }
  public static void main(String args[]) {
    int test[] = {-1, 0, 1};
    System.out.println(longestConsecutive(test));
  }
}

