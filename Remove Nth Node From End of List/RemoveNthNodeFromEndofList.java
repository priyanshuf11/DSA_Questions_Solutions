class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1=new ListNode(0,head);
        ListNode p2=p1;
        for(int i=0;i<n;i++){
            head=head.next;
        }
        while(head!=null){
            head=head.next;
            p2=p2.next;
        }
        p2.next=p2.next.next;
        return p1.next;
    }
}