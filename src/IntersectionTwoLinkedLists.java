import util.ListNode;

/**
 * Created by melvinj on 1/31/15.
 */
public class IntersectionTwoLinkedLists {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int countA =0;
    int countB = 0;
    ListNode tempA = headA;
    ListNode tempB = headB;
    while (tempA != null) {
      tempA = tempA.next;
      countA++;
    }
    while(tempB != null) {
      tempB = tempB.next;
      countB++;
    }
    if (countA == 0 && countB == 0) {
      return null;
    }
    tempA = headA;
    tempB = headB;
    int diff = Math.abs(countA - countB);
    boolean ABigger = countA >= countB ? true : false;
    if (ABigger) {
      while (diff-- > 0) {
        tempA = tempA.next;
      }
    } else {
      while (diff-- > 0) {
        tempB = tempB.next;
      }
    }
    ListNode intersection = null;
    // do parallel traversal
    while (tempA != null && tempB != null) {
      if (tempA == tempB) {
        if (intersection == null) {
          intersection = new ListNode(tempA.val);
        }
        else {
         intersection.next = new ListNode(tempA.val);
        }
      } else {
        intersection = null;
      }
      tempA = tempA.next;
      tempB = tempB.next;
    }
    return intersection;
  }

}
