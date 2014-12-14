/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 10/31/14
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class EditDistance {

  public static String word1;
  public static String word2;
  public static int[][] dp;

  static int solve(int index1, int index2) {
    // base case
    if (index1 == word1.length())
      return word2.length() - index2;
    if (index2 == word2.length())
      return word1.length() - index1;

    int res = dp[index1][index2];
    if (res != -1) {
      return res;
    }
    res = Math.max(word1.length(), word2.length());
    // recurrence
    if (word1.charAt(index1) == word2.charAt(index2)) {
      res = Math.min(res, solve(index1+1, index2+1));
    } else {
      res = Math.min(res, solve(index1+1, index2+1)+1);
    }
    res = Math.min(res, solve(index1+1, index2) + 1);
    res = Math.min(res, solve(index1, index2+1) + 1);
    dp[index1][index2] = res;
    return res;
  }

  public static int minDistance(String w1, String w2) {
    word1 = w1;
    word2 = w2;
    dp = new int[word1.length()][word2.length()];
    for (int i =0; i< word1.length(); i++) {
      for (int j=0; j< word2.length(); j++) {
        dp[i][j] = -1;
      }
    }
    return solve(0, 0);
  }

  public static void main(String args[]) {
    System.out.println(minDistance("cat", "cats"));
    System.out.println(minDistance("cat", "catssad"));
  }
}
