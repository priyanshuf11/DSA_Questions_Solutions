/*
Problem: Intersection of Two Linked Lists
Platform: LeetCode #160
Pattern: Linked List (Two Pointers / Pointer Switching)
Difficulty: Easy

Approach:
- Use two pointers, one starting at the head of each linked list:
  - temp1 → headA
  - temp2 → headB

- Move both pointers one step at a time:
  - if temp1 reaches the end of list A, move it to headB
  - if temp2 reaches the end of list B, move it to headA

- This makes both pointers travel the same total distance:
  - temp1 travels: length(A) + length(B)
  - temp2 travels: length(B) + length(A)

- If the lists intersect:
  - both pointers will eventually meet at the intersection node

- If the lists do not intersect:
  - both pointers will eventually become null at the same time

- Return the node where the two pointers meet.
  - If they meet at null, there is no intersection

Time Complexity: O(n + m)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class 160_Intersection_of_Two_Linked_Lists
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;ListNode temp2=headB;
        while(temp1!=temp2){
            temp1= (temp1==null)? headB : temp1.next;
            temp2= (temp2==null)? headA : temp2.next;
        }
        return temp1;
    }
}
