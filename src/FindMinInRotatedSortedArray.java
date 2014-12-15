/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/15/14
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindMinInRotatedSortedArray {

  public int findMin(int[] num) {
    if (num.length == 0) {
      return 0;
    }

    int l = 0;
    int r = num.length - 1;

    while (l < r) {

      int mid = (l + r) / 2;

      if (mid > 0 && num[mid] < num[mid-1]) {
        return num[mid];
      }

      if (num[l] <= num[mid] && num[mid] > num[r]) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return num[l];
  }
}
