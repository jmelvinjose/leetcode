import util.CreateUtils;
import util.ListNode;
import util.Pair;
import util.PrintUtils;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 1/1/15
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class SortList {

  public ListNode sortList(ListNode head) {
    if (head == null) {
      return null;
    }

    if (head.next == null) {
      return head;
    }

    Pair<ListNode, ListNode> pair = findMiddle(head);
    ListNode first = pair.getFirst();
    ListNode second = pair.getSecond();
    first = sortList(first);
    second = sortList(second);
    return sortedMerge(first, second);
  }

  Pair<ListNode, ListNode> findMiddle(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;
    }
    if (prev != null) {
      prev.next = null;
    }

    return new Pair<ListNode, ListNode>(head, slow);
  }

  ListNode sortedMerge(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    if (l1.val < l2.val) {
      l1.next = sortedMerge(l1.next, l2);
      return l1;
    } else {
      l2.next = sortedMerge(l1, l2.next);
      return l2;
    }
  }

  public static void main(String args[]) {
    SortList s = new SortList();

    ListNode l1 = CreateUtils.createList(5);
    ListNode l2 = CreateUtils.createList(10);
    PrintUtils.printLinkedList(l1);
    PrintUtils.printLinkedList(l2);

    ListNode sorted = s.sortList(l2);
    PrintUtils.printLinkedList(sorted);
  }
}
