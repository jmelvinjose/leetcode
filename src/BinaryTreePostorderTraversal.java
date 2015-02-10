import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by melvinj on 2/9/15.
 */
public class BinaryTreePostorderTraversal {

  List<Integer> res;
  Stack<TreeNode> stack;

  public List<Integer> postorderTraversal(TreeNode root) {
    res = new ArrayList<Integer>();
    stack = new Stack<TreeNode>();

    if (root == null) {
      return res;
    }

    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();

      res.add(0, node.val);

      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }
    return res;
  }

  public static void main(String args[]) {
    BinaryTreePostorderTraversal b = new BinaryTreePostorderTraversal();

    TreeNode test = new TreeNode(1);
    test.right = new TreeNode(2);
    System.out.println(b.postorderTraversal(test));
  }
}
