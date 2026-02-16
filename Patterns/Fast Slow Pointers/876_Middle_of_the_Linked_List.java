/*
Problem: Middle of the Linked List
Platform: LeetCode #876
Pattern: Two Pointers (Fast & Slow)
Difficulty: Easy

Approach:
- use two pointers:
   - slow moves 1 step
   - fast moves 2 steps
- move both pointers until fast reaches the end
- when fast reaches null:
   - slow will be at the middle node

Note:
- If the list has even number of nodes,
  slow points to the second middle (as required by the problem)

Time Complexity: O(n)
Space Complexity: O(1)
*/





//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class 876_Middle_of_the_Linked_List {

    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next !=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
