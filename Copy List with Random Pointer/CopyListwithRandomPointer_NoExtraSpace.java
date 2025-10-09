class CopyListwithRandomPointer_NoExtraSpace {
    public Node copyRandomList(Node head) {
        if(head== null){
            return null;
        }
        
        Node curr=head;
        while(curr!=null){
            Node newnode = new Node(curr.val);
            newnode.next=curr.next;
            curr.next=newnode;
            curr=newnode.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random= curr.random.next;
                
            }
            curr=curr.next.next;
        }

        curr=head;
        Node copyHead=head.next;
        Node clone = copyHead;
        while(clone.next!=null){
            curr.next= curr.next.next;
            clone.next=clone.next.next;

            curr= curr.next;
            clone=clone.next;
        }
        curr.next=null;
        clone.next=null;

        return copyHead;
    }
}