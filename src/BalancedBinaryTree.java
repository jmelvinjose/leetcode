import util.Pair;
import util.TreeNode;

/**
 * Created by melvinj on 2/8/15.
 */
public class BalancedBinaryTree {

  Pair<Boolean, Integer> isBalancedHelpher(TreeNode root) {
    if (root == null) {
      return new Pair<Boolean, Integer>(true, 0);
    }

    Pair<Boolean, Integer> p1 = isBalancedHelpher(root.left);
    Pair<Boolean, Integer> p2 = isBalancedHelpher(root.right);

    if (!p1.getFirst() || !p2.getFirst()) {
      return new Pair<Boolean, Integer>(false, 0);
    }

    if (Math.abs(p1.getSecond() - p2.getSecond()) > 1 ) {
      return new Pair<Boolean, Integer>(false, 0);
    }
    return new Pair<Boolean, Integer>(true, Math.max(p1.getSecond(), p2.getSecond())+1);
  }

  public boolean isBalanced(TreeNode root) {
    return isBalancedHelpher(root).getFirst();
  }
}
