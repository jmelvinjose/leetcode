import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 10/31/14
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaxPointsOnALine {

    class Point {
           int x;
           int y;
           Point() { x = 0; y = 0; }
           Point(int a, int b) { x = a; y = b; }
       }

  public static Map<Integer, Map<Integer, Integer>> map;

  public static int gcd(int a, int b) {
    if (b==0) {
      return a;
    }
    return gcd(b, a%b);
  }

  public static int maxPoints(Point[] points) {
    map = new HashMap<Integer, Map<Integer, Integer>>();
    int res = 0;
    int dup, max;
    for (int i =0; i< points.length; i++) {

      map.clear();
      dup = 0;
      max = 0;
      for (int j=i+1; j< points.length; j++) {
        int x = points[i].x - points[j].x;
        int y = points[i].y - points[j].y;
        if (x==0 && y ==0) {
          dup++;
        }
        int gcd = gcd(x, y);
        if (gcd != 0) {
          x /= gcd;
          y /= gcd;
        }

        if (map.containsKey(x)) {
          Map<Integer, Integer> tempMap = map.get(x);
          if (tempMap.containsKey(y)) {
            tempMap.put(y, tempMap.get(y) + 1);
          } else {
            tempMap.put(y, 1);
          }
          map.put(x, tempMap);
        } else {
          Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
          tempMap.put(y, 1);
          map.put(x, tempMap);
        }

        max = Math.max(max, map.get(x).get(y));
      }
      res = Math.max(res, max+dup+1);
    }
    return res;
  }
}
