import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/16/14
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 *
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class ReversePolishNotation {
  Stack<Integer> operand;
  private static final List<String> operators = Collections.unmodifiableList(Arrays.asList("*", "-", "+", "/"));

  public int evalRPN(String[] tokens) {
    operand = new Stack<Integer>();

    int result = 0;
    for (int i = 0; i < tokens.length; i++) {
      if (operators.contains(tokens[i])) {
        int val2 = operand.pop();
        int val1 = operand.pop();
        operand.push(evaluate(val1, val2, tokens[i]));
      } else {
        operand.push(Integer.parseInt(tokens[i]));
      }
    }
    return operand.peek();
  }

  private int evaluate(int val1, int val2, String oper) {
    if (oper.equals("*")) {
      return val1 * val2;
    } else if (oper.equals("+")) {
      return val1 + val2;
    } else if (oper.equals("-")) {
      return val1 - val2;
    } else {
      return val1 / val2;
    }
  }

  public static void main(String args[]) {

    ReversePolishNotation r = new ReversePolishNotation();

    String[] test = {"2", "1", "+", "3", "*"};

    System.out.println(r.evalRPN(test));
  }
}
