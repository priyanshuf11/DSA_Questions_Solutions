class CopyListwithRandomPointer_HashMap {
    public Node copyRandomList(Node head) {
        Map<Node,Node> mp = new HashMap<>();
        Node cur=head;
        while(cur!=null){
            mp.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            Node newnode = mp.get(cur);
            newnode.next=mp.get(cur.next);
            newnode.random=mp.get(cur.random);
            cur=cur.next;
        }
        return mp.get(head);
    }
}