import util.ListNode;
import util.PrintUtils;

/**
 * Created by melvinj on 2/8/15.
 */
public class ReverseLinkedListII {

  public ListNode reverse(ListNode root) {
    ListNode previous = null;
    while (root != null) {
      ListNode next = root.next;
      root.next = previous;
      previous = root;
      root = next;
    }
    return previous;
  }

  /*public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode start = head;
    ListNode prev = null;
    for (int i = 0; i < (m-1); i++) {
      prev = start;
      start = start.next;
    }
    ListNode res1 = null;
    ListNode res = reverse(start, (n-m), res1);

    if (prev != null) {
      prev.next = res;
      return head;
    } else {
      return res;
    }

  }*/

  public static void main(String args[]) {
    ReverseLinkedListII r = new ReverseLinkedListII();
    ListNode head = new ListNode(3);
    head.next = new ListNode(5);
    head.next.next = new ListNode(7);

    PrintUtils.printLinkedList(r.reverse(head));
  }
}
