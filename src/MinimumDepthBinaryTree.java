import util.TreeNode;

/**
 * Created by melvinj on 2/8/15.
 */
public class MinimumDepthBinaryTree {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }
}
