package codefights.linkedlist;

public class ListPalindrome {

	 
	public static void main(String[] args) {
//		ListPalindrome s = new ListPalindrome();
//		ListNode<Integer> l = new ListNode<Integer>(1);
		
	}
	
    boolean isListPalindrome(ListNode<Integer> l) {
        ListNode<Integer> x = l;

        ListNode<Integer> head = null;
        int index = 0;
        while(x != null) {

           ListNode<Integer> old = head;
           head = new ListNode<Integer>(x.value);
           head.next = old;

           x = x.next;
           index++;
        }

        ListNode<Integer> x2 = head;
        int index2 = 0;
        x = l;
        while(x != null) {
           if(index2 > index / 2) break;
           if(x.value.intValue() != x2.value.intValue()) {
              return false;
           }
           x = x.next;
           x2 = x2.next;
           index2++;
        }
        return true;
}
	
	

	
}
