/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 9/7/14
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseWords {


  public static String reverseWords(String s) {
    if (s.trim().isEmpty()) {
      return "";
    }

    StringBuilder res = new StringBuilder();

    StringBuilder sb = new StringBuilder(s.trim());

    res = reverse(sb, 0, sb.length());
    int start = 0;
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == ' ' || i == sb.length() -1) {
        res = reverse(sb, start, i);
        int countSpace = 0;
        int startSpace = i +1;
        while (++i < sb.length() && sb.charAt(i) == ' ') {
          countSpace++;
        }
        res.append(' ');
        start = i;
      }
    }

    return res.toString();
  }

  public static StringBuilder reverse(StringBuilder sb, int start, int end) {

    for (int j = end - 1, i = 0; i < (end - start)/2; i++, j--) {
      char c = sb.charAt(i);
      sb.setCharAt(i, sb.charAt(j));
      sb.setCharAt(j, c);
    }
    return sb;
  }

  public static void main(String args[]) {
    String res = reverseWords("a   b  c");
    System.out.println(res);
  }
}
