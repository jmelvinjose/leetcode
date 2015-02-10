import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by melvinj on 2/9/15.
 */
public class BinaryTreePreorderTraversal {

  List<Integer> res;
  Stack<TreeNode> stack;

  public List<Integer> preorderTraversal(TreeNode root) {
    res = new ArrayList<Integer>();
    stack = new Stack<TreeNode>();

    if (root == null) {
      return res;
    }
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      res.add(node.val);

      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return res;
  }
}
