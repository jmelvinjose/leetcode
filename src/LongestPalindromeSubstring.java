/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 11/1/14
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindromeSubstring {

  public static String longestPalindrome(String s) {
    char[] str = s.toCharArray();
    int res = Integer.MIN_VALUE;
    int maxMidSingle = 0;
    int maxMid1=0, maxMid2=0;

    for (int i =0; i < str.length; i++) {
      int k = i -1;
      int l = i + 1;

      int count = 1;
      while (k >= 0 && l < str.length && str[k--] == str[l++]) {
        count= count + 2;
      }
      if (count > res) {
        maxMid1 = i;
        maxMid2 = i;
        res = count;
      }
    }


    for (int i=0; i< str.length-1; i++) {
      if (str[i] != str[i+1]) {
        continue;
      }
      int k = i -1;
      int l = i + 2;

      int count = 2;
      while (k >= 0 && l < str.length && str[k--] == str[l++]) {
        count = count+2;
      }
      if (count > res) {
        maxMid1 = i;
        maxMid2 = i+1;
        res = count;
      }
    }
    System.out.println(maxMid1 + "" + maxMid2 + "" + res);
    if (maxMid1 == maxMid2)
      return s.substring(maxMid1 - res/2, maxMid2 + res/2 +1);
    System.out.println(maxMid1 + "" + maxMid2 + "" + res);
    return s.substring(maxMid1 - res/2 +1, maxMid2 + res/2);
  }

  public static void main(String args[]) {
    System.out.println(longestPalindrome("cabad"));
    System.out.println(longestPalindrome("aaaa"));
  }
}
