package me.cwuyi;

import java.util.*;

/**
 * Created by XIA on 2017/7/5.
 */
public class _147 {
    public ListNode insertionSortList(ListNode head) {
        Set<ListNode> set = new TreeSet<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((ListNode)o1).val - ((ListNode)o2).val;
            }
        });

        ListNode now = head;
        while (now != null ) {
            set.add(now);
            now = now.next;
        }

        ListNode holder = new ListNode(0);
        now = holder;
        for (ListNode node : set) {
            now.next = node;
            now = now.next;
        }
        return holder.next;
    }

}
