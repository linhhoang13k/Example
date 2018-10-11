package LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 10/12/2017.
 */
public class C2Q1_RemoveDuplicatesTest {
    @Test
    public void removeDuplicates() throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0);
        list.add(7);
        list.add(3);
        list.add(9);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(2);
        list = C2Q1_RemoveDuplicates.removeDuplicates(list);
        assertEquals("Remove duplicate test failed.", "0 7 3 9 1 4 1 ", list.toString());
    }

    @Test
    public void removeDuplicateWithNoDuplicates() throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(-1);
        list.add(-6);
        list.add(3);
        list.add(9);
        list.add(10);
        list = C2Q1_RemoveDuplicates.removeDuplicates(list);
        assertEquals("Remove duplicate test failed.", "-1 -6 3 9 10 ", list.toString());
    }

}