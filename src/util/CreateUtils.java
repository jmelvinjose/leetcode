package util;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/17/14
 * Time: 12:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateUtils {

  public static final Random r = new Random(42);

  public static ListNode createList(int size) {

    ListNode root = new ListNode(r.nextInt(10));
    ListNode current = root;
    while (size-- > 0) {
      current.next = new ListNode(r.nextInt(10));
      current = current.next;
    }
    return root;
  }

}
