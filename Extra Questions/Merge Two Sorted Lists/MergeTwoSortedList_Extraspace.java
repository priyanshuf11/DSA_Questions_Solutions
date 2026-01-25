class MergeTwoSortedList_Extraspace {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode temp;
         ListNode newnode1= new ListNode();
         if(list1==null){
            return list2;
         }
         else if(list2==null){
            return list1;
         }
        if(list1.val>list2.val){
           
            newnode1.val=list2.val;
            list2=list2.next;
        }
        else{
             newnode1.val=list1.val;
            list1=list1.next;
        }
        head=newnode1;
        temp=newnode1;
        while(list1!=null && list2!=null){
            ListNode newnode= new ListNode();
            if(list1.val>list2.val){
                newnode.val=list2.val;
                temp.next=newnode;
                list2=list2.next;
                temp=newnode;
            }
            else{
                newnode.val=list1.val;
                temp.next=newnode;
                list1=list1.next;
                temp=newnode;
            }
        }
        while(list1!=null){
            ListNode newnode= new ListNode();
            newnode.val=list1.val;
            temp.next=newnode;
            temp=newnode;
            list1=list1.next;
        }
        while(list2!=null){
            ListNode newnode= new ListNode();
            newnode.val=list2.val;
            temp.next=newnode;
            temp=newnode;
            list2=list2.next;
        }
        return head;
    }
}