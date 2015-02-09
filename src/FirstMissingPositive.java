/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 11/21/14
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class FirstMissingPositive {

  public int split(int[] A) {
    int low = -1;
    int high = A.length;

    for (int i = 0; i < high;) {
      if (A[i] > 0) {
        swap(A, i, ++low);
        i++;
      } else {
        swap(A, i, --high);
      }
    }
    return low + 1;
  }

  public int firstMissingPositive(int[] A) {
    int n = split(A);

    for (int i = 0; i < n; i++) {
      if (Math.abs(A[i]) <= n) {
        int index = Math.abs(A[i]) - 1;
        if (A[index] > 0) {
          A[index] = - A[index];
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (A[i] > 0) {
        return i+1;
      }
    }
    return n+1;
  }

  void print(int[] A) {
    for(int i=0; i<A.length; i++) {
      System.out.print(A[i]+"\t");
    }
    System.out.print("\n");
  }
  void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  public static void main(String args[]) {

    FirstMissingPositive f = new FirstMissingPositive();

    int[] test = {-1, -2, 3, 0, 5, -8, 1, -9, 2};
    System.out.println(f.firstMissingPositive(test));
    int[] test2 = {1, 1};
    System.out.println(f.firstMissingPositive(test2));
  }
}
