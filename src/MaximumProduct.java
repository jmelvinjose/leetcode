/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 10/30/14
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaximumProduct {

  public static int maximumProduct(int[] A) {
    int result = A[0];
    int minProd = A[0];
    int maxProd = A[0];

    for (int i=1; i< A.length; i++) {

      if (A[i] < 0) {
        int temp = maxProd;
        maxProd = minProd;
        minProd = temp;
      }

      maxProd = Math.max(A[i], maxProd*A[i]);
      minProd = Math.min(A[i], minProd*A[i]);
      result = Math.max(result, maxProd);
    }
    return result;
  }

  public static void main(String args[]) {
    int[] test1 = {2, -2, 3, 4, -2};
    System.out.println(maximumProduct(test1));
    int[] test2 = {2, -2, 3, 4, -2, -4};
    System.out.println(maximumProduct(test2));
    int[] test3 = {-2, -3, -4};
    System.out.println(maximumProduct(test3));
  }
}
