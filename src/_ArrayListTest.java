package ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 6/4/2017.
 */
public class _ArrayListTest {


    @Test
    public void testIsEmpty() throws Exception{
        _ArrayList<Integer> arr = new _ArrayList<>();
        assertEquals("Test failed: Is empty", true,arr.isEmpty());
        arr.add(1);
        assertEquals("Test failed: Is empty", false,arr.isEmpty());

    }
    @Test
    public void add() throws Exception {
        _ArrayList<Integer> arr = new _ArrayList<>();
        arr.add(1);
        arr.add(Integer.MAX_VALUE);
        arr.add(Integer.MIN_VALUE);
    }

    @Test
    public void testSet() throws Exception {
        _ArrayList<Integer> arr = new _ArrayList<>();
        arr.add(0);
        arr.add(2);
        arr.add(4);
        arr.set(1, 1);
        assertEquals("Test failed: Add at index", 1, (int) arr.get(1));
        arr.set(3, 3);
        arr.set(5, 5);
        assertEquals("Test failed: Add at index", 3, (int) arr.get(3));
        assertEquals("Test failed: Add at index", 5, (int) arr.get(5));


    }



    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet() throws Exception {
        _ArrayList<Integer> arr = new _ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        assertEquals("Test failed: Get element.", 3, (int)arr.get(3));
        assertEquals("Test failed: Get element.", 0, (int)arr.get(-1));
        assertEquals("Test failed: Get element at index out of upper bound", 0, (int)arr.get(4));

    }

    @Test
    public void addObject() throws Exception {
        _ArrayList<Object> arr = new _ArrayList<>();
        arr.add(1);
        arr.add('a');
        arr.add("abc");
        arr.add(true);
        arr.add(new int[] {1, 2, 3});
        arr.add(-1);
    }


    @Test
    public void testIndexOf() throws Exception {
        _ArrayList<Object> arr = new _ArrayList<>();
        arr.add("aa");
        arr.add(("bb"));
        arr.add("cc");
        assertEquals("Test failed: Index of", 1, arr.indexOf("bb"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemove() throws Exception {
        _ArrayList<Integer> arr = new _ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.remove(1);
        arr.remove(-1);
        arr.remove(3);


        assertEquals("Test failed: Remove element at given index", 2, arr.size());

    }

    @Test
    public void testClear() {
        _ArrayList<Integer> arr = new _ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.clear();
        assertEquals("Test failed: Clear an array", 0, arr.size());

    }
}