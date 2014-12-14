/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 11/19/14
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class RegularExpressionMatching {

  char[] s;
  char[] p;
  int n1, n2;
  char[][] dp;

  boolean isEqual(char a, char b) {
    if (a==b) {
      return true;
    }
    if (b=='.') {
      return true;
    }
    return false;
  }

  char isMatchSolve(int index1, int index2) {
    if (index1 == n1 && index2 == n2) {
      return 2;
    }
    if (index2 == n2) {
      return 1;
    }

    if (index1==n1) {
      while(index2+1 < n2 && p[index2+1] == '*') {
        index2 += 2;
      }
      if (index2 == n2) {
        return 2;
      }
      return 1;
    }

    char res = dp[index1][index2];

    if (res != 0) {
      return res;
    }
    res = 1;

    if (index2+1 < n2 && p[index2+1] == '*') {
      res = (char) Math.max(res, isMatchSolve(index1, index2+2));

      if (isEqual(s[index1], p[index2])) {
        res = (char) Math.max(res, isMatchSolve(index1+1, index2));

        res = (char) Math.max(res, isMatchSolve(index1+1, index2+1));
      }
    } else {
      if (isEqual(s[index1], p[index2])) {
        res = (char) Math.max(res, isMatchSolve(index1+1, index2+1));
      }
    }
    return res;
  }

  public boolean isMatch(String s, String p) {
    this.s = s.toCharArray();
    this.p = p.toCharArray();
    n1 = this.s.length;
    n2 = this.p.length;
    dp = new char[n1][n2];
    for (int i =0; i<n1; i++) {
      for (int j=0; j<n2; j++) {
        dp[i][j] = 0;
      }
    }
    return isMatchSolve(0, 0) > 1;
  }

  public static void main(String args[]) {
    RegularExpressionMatching r = new RegularExpressionMatching();

    System.out.println(r.isMatch("aab", "c*a*b"));
  }
}
