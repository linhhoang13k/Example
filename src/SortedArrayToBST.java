/**
 * Question:
   Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

   For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

   Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums, 0, nums.length-1);
    }
    
    TreeNode arrayToBST(int[] nums, int left, int right){
        if(left>right){ return null;}
        if(left == right){
            return new TreeNode(nums[left]);
        }
        
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = arrayToBST(nums, left, mid-1);
        node.right = arrayToBST(nums, mid+1, right);
        return node;
    }
}