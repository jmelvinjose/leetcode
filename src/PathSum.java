import util.TreeNode;

/**
 * Created by melvinj on 2/8/15.
 */
public class PathSum {

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    sum -= root.val;
    if (root.left == null && root.right == null) {
      if (sum == 0) {
        return true;
      }
      return false;
    }

    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
  }
}
