package me.cwuyi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xyy on 2017/6/7.
 */
public class _0607 {

    public static void main(String[] args) {
        _0607 _0607 = new _0607();
        System.out.println(_0607.combinationSum3(3, 63));
    }

    private List<List<Integer>> lists = null;
    public List<List<Integer>> combinationSum3(int k, int n) {
        lists = new ArrayList<>();
        combinationSum3Helper(1, k, n, new ArrayList<Integer>());
        return lists;
    }

    private void combinationSum3Helper(int s, int k, int n, List<Integer> now) {
        if(k < 0) return;
        if(n == 0) {
            if(k != 0) return;
            List<Integer> list = new ArrayList<Integer>(now.size());
            for(Integer i : now) {list.add(i);}
            lists.add(list);
            return;
        }
        for(int i = s; i < 10; i++) {
            if(n - i < 0) return;
            now.add(i);
            combinationSum3Helper(i+1, k - 1, n - i, now);
            now.remove(now.size()-1);
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode now = head;
        while(now != null) {
            list.push(now);
            now = now.next;
        }

        if(list.size() >= 1) {
            now = list.pop();
            head = now;
        }

        while (list.peek() != null) {
            ListNode temp = list.pop();
            now.next = temp;
            now = temp;
        }

        now.next = null;

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}