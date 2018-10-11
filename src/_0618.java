package me.cwuyi;

import java.util.LinkedList;

/**
 * Created by xyy on 2017/6/18.
 */
public class _0618 {

    public static void main(String[] args) {
        System.out.println(smallestFactorization(13));
    }

    public int maxDistance(int[][] arrays) {
        int maxRow = -1;
        int minRow = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arrays.length; i++) {
            int[] array = arrays[i];
            if(array[0] < min) {
                min = array[0];
                minRow = i;
            }
            if(array[array.length-1] > max) {
                max = array[array.length-1];
                maxRow = i;
            }
        }

        if(maxRow != minRow) {
            return max-min;
        }





        return 0;
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        int level = 1;
        while(!list.isEmpty()) {
            if(level == d-1) {
                while (!list.isEmpty()) {
                    TreeNode node = list.poll();
                    TreeNode rowNodeLeft = new TreeNode(v);
                    rowNodeLeft.left = node.left;
                    node.left = rowNodeLeft;

                    TreeNode rowNodeRight = new TreeNode(v);
                    rowNodeRight.right = node.right;
                    node.right = rowNodeRight;
                }
                continue;
            }
            int offset = list.size();
            while(offset-- > 0) {
                TreeNode node = list.poll();
                if(node.left != null) {
                    list.offer(node.left);
                }

                if(node.right != null) {
                    list.offer(node.right);
                }
            }
            level++;
        }
        return root;
    }

    public static int smallestFactorization(int a) {
        if(a == 1) return 1;
        StringBuilder sb = new StringBuilder();
        int offset = 9;
        while(a > 1) {
            int size = sb.length();
            for(int i = offset; i > 1; i--) {
                if(a % i == 0) {
                    sb.insert(0, i);
                    a = a / i;
                    offset = 9;
                    break;
                }
            }
            if(sb.length() == size) {
                return 0;
            }
        }

        if(Long.parseLong(sb.toString()) > Integer.MAX_VALUE) {
            return 0;
        }

        return Integer.parseInt(sb.toString());
    }


}

