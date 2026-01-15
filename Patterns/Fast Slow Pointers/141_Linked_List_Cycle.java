/*
Problem: Linked List Cycle
Platform: LeetCode #141
Pattern: Two Pointers (Fast & Slow)
Difficulty: Easy

Approach (Two Pointers):
- Initialize two pointers `slow` and `fast` at head
- move `slow` by one step and `fast` by two steps
- If `slow` and `fast` ever point to the same node, a cycle exists
- If `fast` or `fast.next` becomes `null`, the list has no cycle (condition for while loop)

- Employs Floyd’s Cycle Detection Algorithm

Time Complexity: O(n)
Space Complexity: O(1)
*/



/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class 141_Linked_List_Cycle {
    

    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow = head;
        if(head == null || head.next == null) return false;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow== fast)return true;

        }
        
        return false;
    }
}