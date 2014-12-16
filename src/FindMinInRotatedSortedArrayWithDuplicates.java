/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/15/14
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 */
public class FindMinInRotatedSortedArrayWithDuplicates {

  public int findMin(int[] num) {
    if (num.length == 0) {
      return 0;
    }

    return findMinHelper(num, 0, num.length-1);
  }

  private int findMinHelper(int[] num, int l, int r) {
    if (l >= r) {
      return num[l];
    }

    int mid = (l + r) / 2;

    if (mid > 0 && num[mid] < num[mid-1]) {
      return num[mid];
    }
    // first half is sorted and pivot is in the second half
    if (num[l] < num[mid] && num[mid] > num[r]) {
      return findMinHelper(num, mid+1, r);
    } else if (num[mid] < num[r] && num[mid] < num[l]) {
      // second half is sorted and pivot is the first half
      return findMinHelper(num, l, mid-1);
    } else {
      // undecided
      return Math.min(findMinHelper(num, l, mid-1), findMinHelper(num, mid+1, r));
    }
  }

  public static void main(String args[]) {
    FindMinInRotatedSortedArrayWithDuplicates f = new FindMinInRotatedSortedArrayWithDuplicates();

    int[] test = {3, 3, 1, 3};
    int min = f.findMin(test);
    System.out.println(min);

  }
}
