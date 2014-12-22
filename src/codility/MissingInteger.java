package codility;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/22/14
 * Time: 9:39 AM
 Write a function:
 class Solution { public int solution(int[] A); }
 that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer that does not occur in A.
 For example, given:
 A[0] = 1
 A[1] = 3
 A[2] = 6
 A[3] = 4
 A[4] = 1
 A[5] = 2
 the function should return 5.
 Assume that:
 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 Complexity:
 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 Elements of input arrays can be modified
 */

public class MissingInteger {

  public int solution(int[] A) {
    // write your code in Java SE 8
    int positive = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] > 0) {
        positive = A[i];
        break;
      }
    }
    if (positive == 0) {
      return 1;
    }
    // replace all negatives with positive
    for (int i = 0; i < A.length; i++) {
      if (A[i] < 0) {
        A[i] = positive;
      }
    }

    for (int i = 0; i < A.length; i++) {
      int index;
      if (A[i] < 0) {
        index = -A[i] - 1;
      }
      else {
        index = A[i] -1;
      }
      if (index >= 0 && index < A.length) {
        if (A[index] >= 0) {
          A[index] *= -1;
        }

      }
    }

    for (int i = 0; i < A.length; i++) {
      if (A[i] > 0) {
        return i+1;
      }
    }
    return A.length+1;

  }

  public static void main(String args[]) {
    MissingInteger m = new MissingInteger();
    int[] test = {0, 1, 2, 3, 4, 5, 7, 8, 9};
    System.out.println(m.solution(test));

  }
}
