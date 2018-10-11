package LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 10/11/2017.
 */
public class MyLinkedListTest {

    @Test
    public void size() throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        assertEquals("Size test failed", 0, list.getSize());
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("Size test failed", 3, list.getSize());
        list.deleteEnd();
        assertEquals("Size test failed", 2, list.getSize());
        list.add(4);
        assertEquals("Size test failed", 3, list.getSize());
        list.delete(2);
        assertEquals("Size test failed", 2, list.getSize());


    }

    @Test
    public void add() throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("Add(Integer) failed", 3, list.getSize());
            MyLinkedList<String> listS = new MyLinkedList<String>();
        listS.add("abc");
        listS.add("def");
        listS.add("ghi");
        assertEquals("Add(String) failed", "abc def ghi ", listS.toString());

    }

    @Test
    public void deleteEnd() throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.deleteEnd();
        assertEquals("Delete end test failed", 2, list.getSize());

    }

    @Test
    public void delete() throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.delete(1);
        assertEquals("Delete head node test failed", 2, list.getSize());
        list.add(1);
        list.add(2);
        list.add(3);
        list.delete(3);
        assertEquals("Delete specific node test failed", 4, list.getSize());

    }

    @Test
    public void printList(){
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("Print list test failed", "1 2 3 ", list.toString());

    }

}