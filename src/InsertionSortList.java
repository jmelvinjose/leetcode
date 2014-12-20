import util.CreateUtils;
import util.ListNode;
import util.PrintUtils;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 12/16/14
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 * https://oj.leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {

  public ListNode insertionSortList(ListNode head) {

    ListNode current = head;

    while (current.next != null) {

      ListNode temp = current;

      // insert temp into right spot

    }
    return null;
  }

  public static void main(String args[]) {

    ListNode temp = CreateUtils.createList(5);

    PrintUtils.printLinkedList(temp);

    ListNode root = temp;
    ListNode toInsert = new ListNode(2);

    toInsert.next = root.next;
    root.next = toInsert;
    PrintUtils.printLinkedList(temp);

  }
}
