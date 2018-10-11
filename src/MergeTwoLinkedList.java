package program.java.linkedlist;

public class MergeTwoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}
	
	ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		  ListNode<Integer> head=l1;
		  ListNode<Integer> check=l1;
		  
		  if(l1==null) return l2;
		  if(l2==null) return l1;
		  //If 2 nd Node has less value. Create new Node
		  if(l2.value<l1.value){
			  ListNode<Integer> newNode = new ListNode<Integer>(l2.value);
			  newNode.next = head;
			  head = newNode;
			  check = head;
			  l2 = l2.next;
		  }
		  while(l2!=null){
			  if(check.next != null){
				  if(check.next.value >= l2.value){
					  ListNode<Integer> newNode = new ListNode<Integer>(l2.value);
					  l2 = l2.next;
					  newNode.next = check.next;
					  check.next = newNode;
				  }else{
					  check = check.next;
				  }
				  
			  }else{
				  check.next = l2;
				  break;
			  }
		  }
		  return head;
	}
	ListNode<Integer> mergeTwoLinkedLists1(ListNode<Integer> l1, ListNode<Integer> l2) {
	    if(l1==null) return l2;
	    if(l2==null) return l1;
	    if(l1.value<l2.value) {
	        l1.next = mergeTwoLinkedLists(l1.next,l2);
	        return l1;
	    }
	    
	    else {
	        l2.next = mergeTwoLinkedLists(l1,l2.next);
	        return l2;
	    }
	}
	 //Definition for singly-linked list:
	class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}
}
