/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 11/2/14
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class InterleavingString {

  static String st1, st2, st3;
  static char[][] dp;

  public static char solve(int i, int j) {
      if ((i+j) == st3.length()) {
        return 2;
      }
      char res = dp[i][j];
      if (res != 0)
        return res;
      res = 1;

      if (i < st1.length() && st1.charAt(i) == st3.charAt(i+j)) {
        res = (char) Math.max(res, solve(i+1, j));
      }
      if (j < st2.length() && st2.charAt(j) == st3.charAt(i+j)) {
        res = (char) Math.max(res, solve(i, j+1));
      }
    dp[i][j] = res;
    return res;
  }

  public static boolean isInterleave(String s1, String s2, String s3) {
    st1 = s1;
    st2 = s2;
    st3 = s3;
    dp = new char[s1.length()+1][s2.length()+1];
    if(st1.length() + st2.length() != st3.length()) {
      return false;
    }

    return solve(0, 0) == 2;
  }

  public static void main(String args[]) {
    System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
  }
}
