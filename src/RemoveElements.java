class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
       ListNode curr = head;
        while(curr.next != null){
           if(curr.next.val == val){
               curr.next = curr.next.next;
           }else{
            curr = curr.next;}
        }
        if (head.val == val){ return head.next;}
        return head;
    }
}