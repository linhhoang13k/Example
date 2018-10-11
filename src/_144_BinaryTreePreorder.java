package Medium;

import java.util.*;
import Utils.TreeNode;

/**
 * Created by Trung on 10/17/2017.
 *
 * Problem statement: Traverse a binary tree pre-order using iterative approach.
 *          1
 *       /     \
 *     2        3
 *   /        /   \
 * 4        5      6
 *
 * Output: 1 2 4 3 5 6
 * Solution: Use a stack to store current visited node so far. Pop from the stack when there is no left node and check
 * for right node.
 *
 */
public class _144_BinaryTreePreorder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        boolean notDone = true;
        while (notDone) {
            if (curr != null) {
                s.push(curr);
                result.add(curr.getVal());
                curr = curr.getLeft();
            } else {
                if (s.isEmpty())
                    notDone = false;
                if (!s.isEmpty()) {
                    curr = s.pop();
                    curr = curr.getRight();
                }
            }
        }
        return result;
    }
}
