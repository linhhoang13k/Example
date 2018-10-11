// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
class IsPalindrome{
ListNode<Integer> getReverse(ListNode<Integer> root){
    ListNode<Integer> current = root;
    ListNode<Integer> prev = null;
    ListNode<Integer> next = null;
    while(current != null){
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}

void printList(ListNode<Integer> root){
    ListNode<Integer> current = root;
    while(current != null){
        System.out.print(current.value + "->");
        current = current.next;
    }
    System.out.println();
}

boolean isListPalindrome(ListNode<Integer> l) {
    if(l == null || l.next == null)
        return true;
    ListNode<Integer> slow = l;
    ListNode<Integer> fast = l;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    if(fast != null)
        slow = slow.next;
    //printList(slow);
    fast = l;
    slow = getReverse(slow);
    //printList(slow1);
    //printList(fast);
    while(fast != null && slow != null){
        if(!slow.value.equals(fast.value))
            return false;
        slow = slow.next;
        fast = fast.next;
    }
    return true;
}
}
