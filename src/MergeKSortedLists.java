import util.CreateUtils;
import util.ListNode;
import util.PrintUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by melvinj on 1/31/15.
 */
public class MergeKSortedLists {

  public ListNode mergeKLists(List<ListNode> lists) {
    if (lists.isEmpty()) {
      return null;
    }

    ListNode result = null;
    ListNode resultHead = null;
    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });
    // add heads to queue
    for (ListNode element : lists) {
      if (element != null) {
        queue.add(element);
      }
    }
    while (!queue.isEmpty()) {
      ListNode head = queue.poll();
      ListNode next = head.next;
      if (next != null) {
        queue.add(next);
      }
      if (result == null) {
        result = new ListNode(head.val);
        resultHead = result;
      } else {
        result.next = new ListNode(head.val);
        result = result.next;
      }
    }
    return resultHead;
  }

  public static void main(String args[]) {
    MergeKSortedLists m = new MergeKSortedLists();
    ListNode result = m.mergeKLists(new ArrayList<ListNode>() {{
     add(CreateUtils.createList(0));
      add(CreateUtils.createList(0));
      add(CreateUtils.createList(0));
      add(CreateUtils.createList(0));
      add(CreateUtils.createList(0));
      add(CreateUtils.createList(0));
      add(CreateUtils.createList(0));
      add(CreateUtils.createList(0));
    }
    });
    PrintUtils.printLinkedList(result);
  }
}
