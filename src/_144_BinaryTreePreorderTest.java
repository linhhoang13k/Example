package Medium;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.lang.*;
import Utils.TreeNode;

/**
 * Created by Trung on 10/17/2017.
 *
 * Source: GeeksForGeeks.org
 */
public class _144_BinaryTreePreorderTest {


    // Java program to find maximum sum leaf to root
// path in Binary Tree
    // driver function to test the above functions
    public static void main(String...args) throws Exception {
        TreeNode root = null;

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0)
        {
            HashMap<Integer, TreeNode> m = new HashMap<> ();
            int n = sc.nextInt();

            root = null;

            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                TreeNode parent = m.get(n1);
                if (parent == null)
                {
                    parent = new TreeNode(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }

                TreeNode child = new TreeNode(n2);
                if (lr == 'L')
                    parent.setLeft(child);
                else
                    parent.setRight(child);
                m.put(n2, child);
                n--;
            }
            t--;
        }
        _144_BinaryTreePreorder solution = new _144_BinaryTreePreorder();
        List<Integer> list = solution.preorderTraversal(root);
        System.out.println(list.toArray().toString());
    }

}