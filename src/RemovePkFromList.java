package codefights;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class RemovePkFromList {

    public static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

        ListNode<Integer> back = l;
        ListNode<Integer> previous = null;
        while (l != null) {
            if (l.value == k) {
                if (previous == null) {
                    back = l.next;
                    if (back != null) {
                        System.out.println("back.value = " + back.value);
                    }
                } else {
                    if (l.next != null && l.next.value != k) {
                        previous.next = l.next;
                        if (previous.next != null) {
                            System.out.println("previous.next.value = " + previous.next.value);
                        }
                    }
                }
            }
            previous = l;
            l = l.next;
        }

        if (back != null && back.value == k) {
            return null;
        }

        return back;
    }
}
