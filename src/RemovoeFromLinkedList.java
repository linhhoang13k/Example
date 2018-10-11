Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k

// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    ListNode<Integer> cur = l;
    ListNode<Integer> prev = null;
     int r=2;
     for(;cur!=null;prev = cur , cur = cur.next ){
         if(prev==null && cur.value ==k){
             while( l!=null && l.value == k){
             l=l.next;
             }
     }
        else if(cur==null){
            return l;
        }
        else if(cur.value==k){

            prev.next=cur.next;
            cur=prev;
        }
        
    }
   
    return l;
}
