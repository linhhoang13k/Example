/**
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        traverseLevel(root, 0, list);
        return list;
    }
    public void traverseLevel(TreeNode root, int level, List<List<Integer>> list){
        if(root != null){
            if(list.size()< level+1){
                list.add(new ArrayList<Integer>());
            }
            list.get(level).add(root.val);
            traverseLevel(root.left, level+1, list);
            traverseLevel(root.right, level+1, list);
        }
        
    }
}