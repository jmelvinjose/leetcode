/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 11/21/14
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class FirstMissingPositive {


  public int firstMissingPositive(int[] A) {

    if (A.length == 1) {
      if (A[0] == 1) {
        return 2;
      } else {
        return 1;
      }
    }

    print(A);
    // swap all negative numbers to the end
    for (int i =0; i < A.length; i++) {
      if (A[i] <=  0) {
        int j = i+1;
        while (j < A.length && A[j] <= 0) {
          j++;
        }
        if (j < A.length) {
          swap(A, i, j);
        }
      }
    }
    print(A);
    int stop = 0;
    for (int i=0; i < A.length && A[i] > 0; i++) {
      stop++;
    }

    // process now
    for (int i=0; i< stop; i++) {
      int index = Math.abs(A[i]);

      if (index < A.length) {
        if (A[index] <= 0) {
          continue;
        }
        A[index] = -1 * A[index];
      } else if (index > A.length){
        return index-1;
      }
    }
    print(A);
    // return now
    for (int i=1; i< A.length; i++) {
      if (A[i] > 0) {
        return i-1;
      }
    }

    return stop+1;
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
