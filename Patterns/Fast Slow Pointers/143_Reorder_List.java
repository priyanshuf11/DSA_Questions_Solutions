/*
Problem: Reorder list
Platform: LeetCode #143 
Pattern: Two Pointers (Fast & Slow)
Difficulty: Medium

Approach:
- use two pointers:
   - slow moves 1 step
   - fast moves 2 steps
- move both pointers until fast reaches the end
- when fast reaches null:
   - slow will be at the middle nodes
- reverse the second half of the linked list
- merge the original first half and reversed second half alternatively

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

class Solution {
    public void reorderList(ListNode head) {
        ListNode fast=head, slow=head;

        // fast reaches end slow reaches at the middle
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        ListNode  prev = null, curr= slow.next;
        slow.next= null;
        //reverse the second half of the linked list
        while(curr != null){
            ListNode nxt= curr.next;
            curr.next= prev;
            prev= curr;
            curr= nxt;    
        }

        // add the nodes from original half and reversed half alternatively
        ListNode temp= head;
        while(temp!= null && prev != null){
            ListNode nxt1 = temp.next,nxt2= prev.next; 
            temp.next= prev;
            prev.next= nxt1;
            temp=nxt1;
            prev= nxt2;
        }
        
    }
}
