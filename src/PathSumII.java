import util.PrintUtils;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melvinj on 2/8/15.
 */
public class PathSumII {

  List<List<Integer>> res;

  public void pathSumHelper(TreeNode root, int sum, List<Integer> current) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      if (sum - root.val == 0) {
        current.add(root.val);
        res.add(new ArrayList<Integer>(current));
        return;
      } else {
        return;
      }
    }

    List<Integer> temp = current;
    temp.add(root.val);

    if (root.left != null) {
      pathSumHelper(root.left, sum - root.val, new ArrayList<Integer>(temp));
    }

    if (root.right != null) {
      pathSumHelper(root.right, sum - root.val, new ArrayList<Integer>(temp));
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    res = new ArrayList<List<Integer>>();
    List<Integer> current = new ArrayList<Integer>();
    pathSumHelper(root, sum, current);
    return res;
  }

  public static void main(String args[]) {
    TreeNode t = new TreeNode(1);
    t.left = new TreeNode(-2);
    t.right = new TreeNode(-2);

    PathSumII p = new PathSumII();

    System.out.println(p.pathSum(t, -1));
  }
}
