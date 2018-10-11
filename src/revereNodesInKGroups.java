// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
    
	ListNode list = new ListNode(0);
	list.next = l;
	ListNode startNode = list;
	int i = 0;

	while (l!=null) {
		i++;
		if (i%k == 0) {
			startNode = reverse(startNode, l.next);
			l = startNode.next;
		}
		else {
			l = l.next;
		}
	}

	return list.next;
}

ListNode reverse(ListNode startNode, ListNode endNode) {
	ListNode curr = startNode.next;
    ListNode next = startNode.next;
    ListNode prev = endNode;

    int count = 0;

    while (curr != endNode) {
    	ListNode temp = curr.next;
    	curr.next = prev;
    	prev = curr;
    	curr = temp;
    }
    startNode.next = prev;

    return next;
}
