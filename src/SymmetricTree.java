/*
 problem : isTreeSymmetric ()
 Given a binary tree t, determine whether it is symmetric around its center, i.e. each side mirrors the other.
    1
   / \
  2   2
 / \ / \
3  4 4  3

 */
 import java.util.*;

 public class SymmetricTree {

   public static boolean isTreeSymmetricRecursive(TreeNode root){
     if(root == null) return true;
     return isTreeSymmetricRecursive(root.left, root.right);
   }
   // Solution : Recursive
   private static boolean isTreeSymmetricRecursive(TreeNode left, TreeNode right){
     if(left == null && right == null) return true;
     if(left == null || right == null) return false;
     if(! left.val.equals(right.val)) return false;
     return isTreeSymmetricRecursive(left.left, right.right) && isTreeSymmetricRecursive(left.right, right.left);
   }

   // Solution Iterative
   public static boolean isTreeSymmetricIterative(TreeNode root){
     if(root == null) return true;
     return isTreeSymmetricIterative(root.left, root.right);
   }

   private static boolean isTreeSymmetricIterative(TreeNode left, TreeNode right){
     Stack<TreeNode> leftStack = new Stack<>();
     leftStack.push(left);
     Stack<TreeNode> rightStack = new Stack<>();
     rightStack.push(right);

     while(! leftStack.isEmpty() && ! rightStack.isEmpty()){
       TreeNode currLeft = leftStack.pop();
       TreeNode currRight = rightStack.pop();
       if(currLeft == null && currRight == null) // if both are null continue
         continue;
       if(currLeft == null || currRight == null) //i f one of them is null then return false
          return false;
       if(! currLeft.val.equals(currRight.val)) // check the node values if they are equal
          return false;

       leftStack.push(currLeft.left); //leftstack left node
       rightStack.push(currRight.right); // right stack  right node
       leftStack.push(currLeft.right); //left stack right node
       rightStack.push(currRight.left); // rightStack left node
     }
     return leftStack.isEmpty() && rightStack.isEmpty(); // make sure both are empty
   }

   private static class TreeNode {
     private int val;
     private TreeNode left;
     private TreeNode right;
     private TreeNode(int value){
       this.val = value;
     }
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);
      boolean isTreeSymmetricR = isTreeSymmetricRecursive(root);
      System.out.println("isTreeSymmetricR = " +isTreeSymmetricR);

      boolean isTreeSymmetricI = isTreeSymmetricIterative(root);
      System.out.println("isTreeSymmetricI = " +isTreeSymmetricI);
   }

 }
