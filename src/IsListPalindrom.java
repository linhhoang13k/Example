package linked_lists;

public class IsListPalindrom {
	
	private LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> prev, current, next;
		
		current = head;
		prev = null; next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;
	}
	
	private boolean compare(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
		while(l1 != null && l2 != null) {
			if(l1.value != l2.value)
				return false;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		return true;
	}

	public boolean isListPalindrom(LinkedListNode<Integer> head) {
		
		if(head == null) return false;
		
		LinkedListNode<Integer> slow, fast, prevOfSlow;
		
		slow = head;
		fast = head;
		prevOfSlow = null;
		
		while(fast != null && fast.next != null) {
			prevOfSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast == null) {
			int cond = slow.value - prevOfSlow.value;
			if(cond == 0) {
				fast = head;
				slow = slow.next;
				slow = reverse(slow);
				
				 while(fast != prevOfSlow && slow != null){
					 	int cond_1 = fast.value - slow.value;
		                if(cond_1 == 0){
		                    slow = slow.next;
		                    fast = fast.next;
		                    continue;
		                }
		                else
		                    return false;
		            }
		            return true;
			}
			else {
				return false;
			}
		}
		else {
			fast = head;
			slow = slow.next;
			slow = reverse(slow);
			
			while(fast != prevOfSlow && slow != null){
				int cond_1 = fast.value = slow.value;
                if(cond_1 == 0){
                    slow = slow.next;
                    fast = fast.next;
                    continue;
                }
                else
                    return false;
            }
            return true;
			
		}
	}
}
