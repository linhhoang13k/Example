package program.java.linkedlist;

import program.java.linkedlist.ReverseNodesInKGroups.ListNode;



public class RearrangeList {

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(1);
		ListNode<Integer> node1 = new ListNode<Integer>(2);
		ListNode<Integer> node2 = new ListNode<Integer>(3);
		ListNode<Integer> node3 = new ListNode<Integer>(4);
		ListNode<Integer> node4 = new ListNode<Integer>(5);
		ListNode<Integer> node5 = new ListNode<Integer>(6);
		ListNode<Integer> node6 = new ListNode<Integer>(7);
		ListNode<Integer> node7 = new ListNode<Integer>(8);
		ListNode<Integer> node8 = new ListNode<Integer>(9);
		ListNode<Integer> node9 = new ListNode<Integer>(10);
		ListNode<Integer> node10 = new ListNode<Integer>(11);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		ListNode<Integer> res = rearrangeLastN(head,3);
		while(res!=null){
			System.out.print(res.value+" ");
			res = res.next;
		}

	}
	public static ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
		if(n==0){
			return l;
			
		}
		if(l==null){
			return l;
		}
		ListNode<Integer> oldEnd = l;
		ListNode<Integer> newStart = l;
		ListNode<Integer> newend = l;
		n--;
		while(n>0){
			oldEnd = oldEnd.next;
			n--;
		}
		while(oldEnd.next!=null){
			if(newStart!=newend){
				newend = newend.next;
			}
			newStart = newStart.next;
			oldEnd = oldEnd.next;
		}
		if(newStart!=newend){
			newend.next = null;
			oldEnd.next = l;	
		}
		
		return newStart;
	}

	
	// Definition for singly-linked list:
	static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}
}
