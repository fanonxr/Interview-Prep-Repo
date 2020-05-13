package LinkedList;

public class Solution {

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
}
