/**
 * Created by melvinj on 2/9/15.
 */
public class ClimbStairs {

  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }

    int first = 1;
    int second = 2;
    int res = 0;
    for (int i = 2; i < n; i++) {
      res = first + second;
      first = second;
      second = res;
    }
    return  res;
  }
}
