class AddTwoNumbers_optimal {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode current=l1;
        ListNode prev=null;
        while(l1!=null || l2!=null ||carry!=0){
            int val1= (l1==null)?0:l1.val;
            int val2= (l2==null)?0:l2.val;
            int sum= val1+val2+carry;
            carry= sum/10;
            if(l1!= null){
                l1.val=sum%10;
                prev=l1;
                l1=l1.next;
                
            }
            else{
                prev.next= new ListNode(sum%10);
                prev=prev.next;
            }
            if(l2 != null) l2=l2.next;

        }
        return current;
    }
}