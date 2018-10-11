import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by POWERHOUSE on 02/25/2018.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SerializeDeserializeBT {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result=new StringBuilder("");
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) {
            q.add(root);
            result.append(root.val);
            TreeNode current;
            while(q.peek()!=null) {
                current=q.poll();
                if(current.left!=null) {
                    q.add(current.left);
                    result.append(',');
                    Integer temp = current.left.val;
                    result.append(temp.toString());
                }
                else
                    result.append(",n");
                if(current.right!=null) {
                    q.add(current.right);
                    result.append(',');
                    Integer temp = current.right.val;
                    result.append(temp.toString());
                }
                else
                    result.append(",n");
            }
        }
        return result.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] input = data.split(",");
        TreeNode root=null;
        if(input.length>0 && input[0].length()!=0) {
            int i=0;
            root = new TreeNode(Integer.parseInt(input[i]));
            TreeNode current = root;
            i++;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(current);
            while(q.peek()!=null && i<input.length) {
                current = q.poll();
                if(!input[i].equals("n")) {
                    current.left = new TreeNode(Integer.parseInt(input[i++]));
                    q.add(current.left);
                }
                else {
                    current.left = null;
                    i++;
                }
                if(!input[i].equals("n")) {
                    current.right = new TreeNode(Integer.parseInt(input[i++]));
                    q.add(current.right);
                }
                else {
                    current.right = null;
                    i++;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left=null;
        root.right.left.right=null;
        root.right.right.left=null;
        root.right.right.right=null;

        SerializeDeserializeBT obj = new SerializeDeserializeBT();
        String tree = obj.serialize(root);
        System.out.println("Serialized string is: " + tree);
        TreeNode temp = obj.deserialize(tree);
        System.out.println("String after serializing the deserialized tree again: " + obj.serialize(temp));
        System.out.println("Is it same??");

    }

}

