public class RemoveElementFromList {

    public ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode head = new ListNode(0);
        ListNode last = head;

        while (l != null) {
            if (l.value != k) {
                last.next = l;
                last = last.next;
            }
            l = l.next;
        }

        if (last.next != null && last.next.value.equals(k)) last.next = null;
        return head.next;
    }

    public ListNode<Integer> removeKFromList1(ListNode<Integer> l, int k) {
        ListNode list = new ListNode(0);
        ListNode temp = list;

        while (l != null) {
            if (l.value != k) {
                temp.next = l;
                temp = temp.next;
            }
            l = l.next;
        }
        temp.next = null;
        return list.next;
    }

}
