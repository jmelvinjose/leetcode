import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 10/31/14
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class WordBreakII {

  public static String str;
  public static Set<String> dict;
  static int[] dp;
  static List<String> result;

  static void solve(int index, String poss) {

    // base case
    if (index == str.length()) {
      System.out.println(poss);
      result.add(poss);
    }
    int res = dp[index];
    if (res == 0) {
      return;
    }
    // recurrence
    for (int i = index; i <= str.length(); i++) {
      if (dict.contains(str.substring(index, i))) {
        dp[i] = 1;
        if (index != 0)
          solve(i, poss + " " + str.substring(index, i));
        else
          solve(i, poss + str.substring(index, i));
      } else {
        dp[i] = 0;
      }
    }
  }

  public static List<String> wordBreak(String s, Set<String> d) {
    str = s;
    dict = d;
    dp = new int[s.length()+1];
    for (int i=0; i<dp.length; i++) {
      dp[i] = -1;
    }
    result = new ArrayList<String>();
    solve(0, "");
    return result;
  }

  public static void main(String args[]) {
    Set<String> dict2 = new HashSet<String>();
    dict2.add("cat"); dict2.add("cats"); dict2.add("and"); dict2.add("sand"); dict2.add("dog");
    wordBreak("catsanddog", dict2);
  }
}
