import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by melvinj on 2/9/15.
 */
public class BinaryTreeInorderTraversal {

  List<Integer> result;
  Stack<TreeNode> stack;

  public void pushLeft(TreeNode node) {

    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    result = new ArrayList<Integer>();
    stack = new Stack<TreeNode>();

    pushLeft(root);

    while (!stack.isEmpty()) {
      TreeNode left = stack.pop();
      result.add(left.val);
      pushLeft(left.right);
    }
    return result;
  }


}
