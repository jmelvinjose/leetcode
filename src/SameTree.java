/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 11/2/14
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class SameTree {
  public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    } else {
      return false;
    }
  }
}
