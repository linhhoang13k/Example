package Utils;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Trung on 10/19/2017.
 */
public class CreateTree {

    /**
     * Source: GeeksForGeeks.org
     * Input format:
     * # of edges
     * Nodes
     *
     * Example: For a tree
     *          1
     *         / \
     *        2   3
     *      /      \
     *    4         5
     *
     * Input will be:
     * 4
     * 1 2 L 1 3 R 2 4 L 3 5 R
     *
     * @return A tree
     */
    public static TreeNode readConsole() {
        TreeNode root;
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, TreeNode> m = new HashMap<>();
        int n = 0;
        if (sc.hasNext())
            n = sc.nextInt();
        root = null;
        while (n > 0 && sc.hasNext()) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            char lr = sc.next().charAt(0);

            //  cout << n1 << " " << n2 << " " << (char)lr << endl;
            TreeNode parent = m.get(n1);
            if (parent == null) {
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
        return root;
    }
}
