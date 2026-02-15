/*
Problem: Remove Nth Node From End of List
Platform: LeetCode #19
Pattern: Two Pointers (Fast & Slow)
Difficulty: Medium

Approach (Two Pointers):
- Initialize two pointers `slow` and `fast` at head
- move `slow` by one step and `fast` by two steps
- If `slow` and `fast` ever point to the same node, a cycle exists
- If `fast` 

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p1 = new ListNode(0, head);
    ListNode p2 = p1;
    for (int i = 0; i < n; i++) {
      head = head.next;
    }
    while (head != null) {
      head = head.next;
      p2 = p2.next;
    }
    p2.next = p2.next.next;
    return p1.next;
  }
}
