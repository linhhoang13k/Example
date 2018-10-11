package br.com.codefights.linkedlist;

import java.util.ArrayList;

public class RemoveKFromList {

	ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
		
		ListNode<Integer> aux =  null;
		ListNode<Integer> Antaux = new ListNode(null);
		ListNode<Integer> firstElementAux =  null;
		
		if(l == null){
			return null;
		}
		
		while(l.next != null){	
			
			if(l.value != k){
				if(aux == null){
					aux = l;
					firstElementAux = aux;
				}else{
					aux.next = l;
					aux = aux.next;
				}
								
			}
			
			Antaux = l;
			l = l.next;
		}		
		
		if(l.value == k){
			Antaux.next = null;			
		}
		
		return firstElementAux;

	}
	
	ListNode<Integer> betterSolution(ListNode<Integer> l, int k) {
	    ListNode<Integer> newHead = new ListNode<>(null);
	    newHead.next = l;
	    
	    ListNode<Integer> current = l;
	    ListNode<Integer> previous = newHead;
	    while(current != null) {
	        if(current.value == k) {
	            previous.next = current.next;
	            current = current.next;
	        }
	        else {
	            previous = current;
	            current = current.next;
	        }
	    }
	    
	    return newHead.next;
	}
	
	public static void main(String[] args) {		
		
		
		ListNode<Integer> l1 = new ListNode<Integer>(123);
		ListNode<Integer> l2 = new ListNode<Integer>(456);
		ListNode<Integer> l3 = new ListNode<Integer>(789);
		ListNode<Integer> l4 = new ListNode<Integer>(0);
		
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		
		/*ListNode<Integer> l1 = new ListNode<Integer>(3);
		ListNode<Integer> l2 = new ListNode<Integer>(1);
		ListNode<Integer> l3 = new ListNode<Integer>(2);
		ListNode<Integer> l4 = new ListNode<Integer>(3);
		ListNode<Integer> l5 = new ListNode<Integer>(4);
		ListNode<Integer> l6 = new ListNode<Integer>(5);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;*/
		
		/*ListNode<Integer> l1 = new ListNode<Integer>(1000);
		ListNode<Integer> l2 = new ListNode<Integer>(1000);
		
		l1.next = l2;*/

		
/*
		ListNode<Integer> l1 = new ListNode<Integer>(1);
		ListNode<Integer> l2 = new ListNode<Integer>(2);
		ListNode<Integer> l3 = new ListNode<Integer>(3);
		ListNode<Integer> l4 = new ListNode<Integer>(4);
		ListNode<Integer> l5 = new ListNode<Integer>(5);
		ListNode<Integer> l6 = new ListNode<Integer>(6);
		ListNode<Integer> l7 = new ListNode<Integer>(7);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;*/

		
		ListNode<Integer> x = l1;
		do{
			System.out.println(x.value);
			x = x.next;
			
		}while(x != null);
		
		
		System.out.println("------");
		
		
	
		RemoveKFromList test = new RemoveKFromList();
		x = test.removeKFromList(l1, 0);
		
	
		do{
			System.out.println(x.value);
			x = x.next;
			
		}while(x != null);
		//System.out.println(test.removeKFromList(inputString));
		
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
//