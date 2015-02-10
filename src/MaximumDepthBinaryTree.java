import util.TreeNode;

/**
 * Created by melvinj on 2/8/15.
 */
public class MaximumDepthBinaryTree {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
