package codility;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/22/14
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaxCounters {

  public int[] solution(int N, int[] A) {
    // write your code in Java SE 8
    int maxCounter = -1, maxValue = Integer.MIN_VALUE;
    int finalMax = Integer.MIN_VALUE;
    int[] counters = new int[N];
    int[] zeros = new int[N];

    for (int i = 0; i < A.length; i++) {
      if (A[i] >= 1 && A[i] <= N) {
        int currentValue = counters[A[i]-1];
        if (currentValue < finalMax) {
          counters[A[i]-1] = finalMax + 1;
        } else {
          counters[A[i] -1]++;
        }
        int value = counters[A[i] -1];
        if (value > maxValue) {
          maxValue = value;
        }
      } else if (A[i] == N+1){
        finalMax = maxValue;
      }
    }

    for (int i = 0; i < N; i++) {
      counters[i] = Math.max(finalMax, counters[i]);
    }

    return counters;
  }
  
}
