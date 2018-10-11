package tiendm.codefight.challenge.july;

public class BrothersInTheBar {
	int brothersInTheBar(int[] a) {
		Node first = new Node(a[0], null, null);
		ListNode list = new ListNode(first);
		int i = 1;
		Node cur = first;
		while (i < a.length) {
			cur = list.addNode(cur, new Node(a[i], null, cur));
			i++;
		}
		int total = 0;
		cur = first;
		while (list.size > 3 && cur != null) {
			if(cur.next == null){
				break;
			} 
			Node next = cur.next;
			if(cur.item != next.item){
				cur = next;
				continue;
			}
			Node next2 = next.next;
			if(next2 == null){
				break;
			}
			if(next.item != next2.item){
				cur = next2;
				continue;
			}
			total++;
			list.remove(next2);
			list.remove(next);
			cur = list.remove(cur);
			if(cur.prev != null && cur.prev.item == cur.item){
				cur = cur.prev;
			}
		}
		if(list.size == 3 && cur != null && cur.next != null && cur.next.next != null 
				&& cur.item == cur.next.item && cur.next.item == cur.next.next.item){
			total++;
		}
		return total;
    }
	
	public static void main(String[] args) {
    	int[] x = {1, 1, 2, 3, 3, 3, 2, 2, 1, 1};
		BrothersInTheBar b = new BrothersInTheBar();
		System.out.println(b.brothersInTheBar(x));
	}
    
	class ListNode{
		public int size;
		public Node first;
		public ListNode(Node first) {
			super();
			this.first = first;
			size++;
		}
		public Node addNode(Node cur, Node a){
			cur.next = a;
			a.prev = cur;
			a.next = null;
			size++;
			return a;
		}
		public Node remove(Node n){
			Node prev = n.prev;
			if(prev == null){
				Node next = n.next;
				next.prev = null;
				return next;
			}
			prev.next = n.next;
			if(n.next != null){
				n.next.prev = prev;
			}
			n.next = null;
			n.prev = null;
			size--;
			return prev;
		}
	}
	
	class Node{
		public int item;
		public Node next;
		public Node prev;
		public Node(int item, Node next, Node prev) {
			super();
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
    
    
    
}
