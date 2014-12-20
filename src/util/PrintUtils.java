package util;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/17/14
 * Time: 12:03 AM
 * A utility class to help print different data structures
 */
public class PrintUtils {

  public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + "\t");
    }
    System.out.println();
  }

  public static void printLinkedList(ListNode root) {

    while(root.next.next != null) {
      System.out.print(root.val + " --> ");
      root = root.next;
    }
    System.out.println(root.next.val);
  }

}
