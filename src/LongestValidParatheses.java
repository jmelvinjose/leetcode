import java.util.Stack;

/**
 * Created by melvinj on 2/10/15.
 */
public class LongestValidParatheses {

  public int longestValidParentheses(String s) {
    char[] arr = s.toCharArray();
    int last = -1;
    int res = 0;
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == ')' && stack.isEmpty()) {
        last = i;
        continue;
      }
      if (arr[i] == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          res = Math.max(res, i - last);
        } else {
          res = Math.max(res, i - stack.peek());
        }
      }
    }
    return res;
  }
}
