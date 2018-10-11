package LinkedList;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Trung on 10/12/2017.
 */
public class C2Q1_RemoveDuplicates {

    /**
     * Runtime: O(n) Space: O(n)
     *
     * @param list
     * @return
     */
    public static MyLinkedList removeDuplicates(MyLinkedList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (map.get(n) == null) map.put(n, 1);
            else {
                itr.remove();
            }
        }
        return list;
    }


    public static MyLinkedList removeDuplicatesNoBuffer(MyLinkedList<Integer> list) {
        return null;
    }

}
