/*
Problem: Linked List Cycle II
Platform: LeetCode #142
Pattern: Two Pointers (Fast & Slow)
Difficulty: Medium

Approach:
- Use two pointers:
   - slow moves 1 step
   - fast moves 2 steps
- If there is a cycle, fast and slow will meet inside the loop
- When they meet:
   - move one pointer back to the head
   - move both pointers one step at a time
- The node where they meet again is the start of the cycle

Intuition :
- Fast pointer always catches slow inside a cycle
- Resetting one pointer to head aligns both pointers
  so they reach the cycle start at the same time
- !! to understand the math behind this , look for any detailed solution

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

public class 142_Linked_List_Cycle_II {
    
    public ListNode detectCycle(ListNode head) {
        ListNode fast= head;
        ListNode slow= head;
        boolean hasCycle= false; // a flag to check if cycle exist

        // similar logic as Linked List Cycle
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                hasCycle = true;
                break;
            }
        }
        // to find the start of cycle
        if(hasCycle){
            fast= head;
            while(fast != slow){
                fast= fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }
}
