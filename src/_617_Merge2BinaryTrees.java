package Easy;

import Utils.CreateTree;
import Utils.TreeNode;
/**
 * Created by Trung on 10/17/2017.
 */
public class _617_Merge2BinaryTrees {

    public static TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null)
        {
            t1.setVal(t2.getVal() + t1.getVal());
        } else {
            return t1 == null ? t2 : t1;
        }


        return t1;
    }

    public static void main(String...args) {
        TreeNode tree1 = CreateTree.readConsole();
        TreeNode tree2 = CreateTree.readConsole();
        System.out.println(tree1);
        System.out.println(tree2);

    }
}
