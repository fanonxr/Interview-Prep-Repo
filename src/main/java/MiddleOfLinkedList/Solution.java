package MiddleOfLinkedList;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;

    ListNode midNode = solution.middleNode(node1);

    System.out.println("Middle Node: " + midNode.val);
  }

  public ListNode middleNode(ListNode head) {
    if (head == null) return null;
    // progress through the entire linked list and get the total size
    int size = 0;
    ListNode temp = head;
    while (temp != null) {
      size += 1;
      temp = temp.next;
    }

    // check edge case for size of 1
    if (size == 1) {
      return head;
    }

    // get the halfway point for the size
    int halfway = size / 2;

    ListNode midNode = null;
    int counter = 0;

    while (counter < halfway) {
      head = head.next;
      midNode = head;
      counter++;
    }

    return midNode;
  }

  public ListNode anotherMiddleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}

