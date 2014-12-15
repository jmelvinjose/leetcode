import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/15/14
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 *
 * https://oj.leetcode.com/problems/min-stack/
 *
 */

  public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
      stack = new Stack<Integer>();
      minStack = new Stack<Integer>();
    }

    public void push(int x) {
      if (x <= getMin()) {
        minStack.push(x);
      }
      stack.push(x);
    }

    public void pop() {
      int value = stack.pop();
      if (getMin() == value) {
        minStack.pop();
      }
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      if (minStack.isEmpty()) {
        return Integer.MAX_VALUE;
      } else {
        return minStack.peek();
      }
    }
  }
