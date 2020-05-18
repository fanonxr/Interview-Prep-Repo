package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public ListNode reverseLinkedList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;

    while (curr != null) {
      next = curr.next; // save the next node
      curr.next = prev; // reverse the next to the prev
      prev = curr; // advance prev
      curr = next; // advance curr
    }

    return prev; // new head is the head of th list
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;

    for (int i = 1; i <= n + 1; i++) {
      first = first.next;
    }

    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }

  public ListNode mergeTwoList(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        dummy.next = l1;
        l1 = l1.next;
      } else {
        dummy.next = l2;
        l2 = l2.next;
      }
      // update dummy
      dummy = dummy.next;
    }

    // append the rest of the list if the any of the lists are finished
    if (l1 != null) {
      dummy.next = l1;
    } else if (l2 != null) {
      dummy.next = l2;
    }

    // return head.next because head is a ref to dummy back when it was the first ref
    return head.next;
  }

  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;

    // create our pointers for even and odds
    ListNode even = head;
    ListNode odd = head.next;
    ListNode oddHead = odd;

    while (odd != null && odd.next != null) {
      even.next = odd.next;
      even = odd.next;
      odd.next = even.next;
      odd = even.next;
    }

    even.next = oddHead;
    return head;
  }

  public ListNode checkForCycle(ListNode linkedList1, ListNode linkedList2) {
    // create a hashset to store if we have seen it in one of the list
    Set<ListNode> set = new HashSet<>();
    // loop over the first list and add all the contents to it
    ListNode listHead = linkedList1;
    while (listHead != null) {
      // add to the set
      set.add(listHead);
      listHead = listHead.next;
    }

    // now check if the set contains an item from the second list
    ListNode listHead2 = linkedList2;
    while (listHead2 != null) {
      if (set.contains(listHead2)) {
        return listHead2;
      }
      listHead2 = listHead2.next;
    }
    return null;
  }

  public ListNode removeKthToLast(ListNode head, int k) {
    // create our dummy node to point to the head
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    // create our right bound
    ListNode rightBound = dummy.next;
    // create our window
    while (k > 0) {
      rightBound = rightBound.next;
      k--;
    }

    // create our left bound
    ListNode leftBound = dummy;
    // check when the right will be null
    while (rightBound != null) {
      // progress the left and right
      leftBound = leftBound.next;
      rightBound = rightBound.next;
    }

    leftBound.next = leftBound.next.next;

    return dummy.next;
  }

}
