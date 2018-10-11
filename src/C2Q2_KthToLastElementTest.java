package LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 12/13/2017.
 */
public class C2Q2_KthToLastElementTest {
    @Test
    public void kthToLastElementTest() throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        assertEquals("Kth to last element test failed", "4",
                C2Q2_KthToLastElement.kthToLastElement(list, 3).toString() );
    }
    @Test
    public void kthToLastElementTestNull() throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        assertEquals("Kth to last element test with null list failed", null,
                C2Q2_KthToLastElement.kthToLastElement(list, 3));
    }

    @Test
    public void kthToLastElementTestOutOfBounds() throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        assertEquals("Kth to last element test with out of bound failed", null,
                C2Q2_KthToLastElement.kthToLastElement(list, 7));
    }
}