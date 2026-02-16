
/*
Problem: Copy List with Random Pointer
Platform: LeetCode #138
Pattern: Linked List Manipulation (Interleaving Technique)
Difficulty: Medium

Approach:
- Traverse the original list
  - for each node, create a new node with the same value
  - insert this new node just after the original node
  - the listst becomes: A → A' → B → B' → C → C'

- Assign random pointers to the copied nodes:
  - for each original node:
     - if original.random != null
       copied.random = original.random.next
     - because original.random.next points to the copied version
       of the random node

- Separate the combined list into two lists:
  - restore the original list
  - extract the copied nodes into a new list

- Return the head of the copied list

Time Complexity: O(n)
Space Complexity: O(1)
*/

//Definition for singly-linked list.
class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

class Solution {
  public Node copyRandomList(Node head) {
    Node t = head;

    // add one node after every existing node with the same value
    while (t != null) {
      Node x = new Node(t.val);
      x.next = t.next;
      t.next = x;
      t = t.next.next;
    }
    Node temp = head;

    // logic to copy random pointers
    // next of (random of original) == random of (next of original)
    while (temp != null) {
      Node c = temp.next;
      if (temp.random != null) {
        c.random = temp.random.next;
      } else {
        c.random = null;
      }
      temp = temp.next.next;

    }

    // seperate the original and copied linked list

    temp = head; // temp travers the combined linked list
    Node d = new Node(-1);
    Node res = d; // res helps build the copied linked list

    // logic to seperate linked lists
    while (temp != null) {
      res.next = temp.next;
      res = res.next;
      temp.next = temp.next.next;
      temp = temp.next;

    }
    return d.next;

  }
}
