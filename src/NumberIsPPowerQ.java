import java.util.HashMap;
import java.util.Map;

/**
 * Created by melvinj on 1/31/15.
 */
public class NumberIsPPowerQ {

  public static Map<Integer, Integer> primeFactorize(int num) {
    Map<Integer, Integer> res = new HashMap<Integer, Integer>();
    int numCopy = num;
    for (int i = 2; i < numCopy; i++) {
      if (num % i == 0) {
        int count = 0;
        while (num % i == 0) {
          count++;
          num = num / i;
        }
        res.put(i, count);
      }
    }
    return res;
  }

  public static void main(String args[]) {
    Map<Integer, Integer> res = primeFactorize(216);
    System.out.println(res);
  }
}
