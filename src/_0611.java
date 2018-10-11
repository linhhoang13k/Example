package me.cwuyi;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by xyy on 2017/6/11.
 */
public class _0611 {

    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L2e2t2C2o2d2e23");
        iterator.next(); // return 'L'
        iterator.next(); // return 'e'
        iterator.next(); // return 'e'
        iterator.next(); // return 't'
        iterator.next(); // return 'C'
        iterator.next(); // return 'o'
        iterator.next(); // return 'd'
        iterator.hasNext(); // return true
        iterator.next(); // return 'e'
        iterator.hasNext(); // return false
        iterator.next(); // return ' '
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode nowNode = new TreeNode(0);
        if(t1 == null && t2 == null) {
            return null;
        } else if(t1 != null && t2 == null) {
            nowNode.val = t1.val;
            nowNode.left = mergeTrees(t1.left, t2);
            nowNode.right = mergeTrees(t1.right, t2);
        } else if(t1 == null && t2 != null) {
            nowNode.val = t2.val;
            nowNode.left = mergeTrees(t1, t2.left);
            nowNode.right = mergeTrees(t1, t2.right);
        } else {
            nowNode.val = t1.val + t2.val;
            nowNode.left = mergeTrees(t1.left, t2.left);
            nowNode.right = mergeTrees(t1.right, t2.right);
        }
        return nowNode;
    }

    public int triangleNumber(int[] nums) {
        //判定三角形，应该从大到小排序，满足a>=b>=c时，a<b+c即可
        Arrays.sort(nums);
        int ret = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) continue;
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] <= nums[k]) {
                        break;
                    }
                    ret++;
                }

            }
        }

        return ret;
    }
}

class StringIterator {
    private LinkedList<Character> listChr;
    public StringIterator(String compressedString) {
        listChr = new LinkedList<>();
        for(int i = 0; i < compressedString.length();) {
            int k = 1;
            while((i+k) < compressedString.length() && compressedString.charAt(i+k) >= '0' && compressedString.charAt(i+k) <= '9') {
                k++;
            }
            String temp = compressedString.substring(i+1, i+k);
            for(int j = 0; j < Integer.parseInt(compressedString.substring(i+1, i+k)); j++) {
                listChr.offer(compressedString.charAt(i));
            }
            i = i + k;
        }
    }

    public char next() {
        if(hasNext()) {
            return listChr.poll();
        } else {
            return ' ';
        }

    }

    public boolean hasNext() {
        if(listChr.peek() == null) {
            return false;
        } else {
            return true;
        }
    }
}

