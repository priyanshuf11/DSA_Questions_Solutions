class PartitionList_twoLists {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller= new ListNode(-1);
        ListNode larger= new ListNode(-1);

        ListNode before =smaller;
        ListNode after =larger;
        ListNode curr=head;

        while(curr!=null){
            if(curr.val<x){
                before.next=curr;
                before=before.next;
            }
            else{
                after.next=curr;
                after=after.next;
            }
            curr=curr.next;
        }
        after.next=null;
        before.next=larger.next;

        return smaller.next;
    }
}