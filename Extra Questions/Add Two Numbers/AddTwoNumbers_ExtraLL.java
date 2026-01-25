/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbers_ExtraLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        int carry=0;
        ListNode current=null;
        ListNode res=null;
        while(temp1!=null || temp2!=null || carry!=0){
            int val1= (temp1==null)?0:temp1.val;
            int val2= (temp2==null)?0:temp2.val;
            int sum=val1+val2+carry;
            carry=sum/10;
            if(current==null){
                current= new ListNode(sum%10);
                res=current;
            }
            else{
                current.next= new ListNode(sum%10);
                current= current.next;
            }
            if(temp1 != null) temp1=temp1.next;
            if(temp2 != null) temp2=temp2.next;
            
        }
        return res;
    }
}