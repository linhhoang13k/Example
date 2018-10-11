/*
 problem : Has Pathsum in Binary tree
 Given a binary tree t and an integer s, determine whether there is a root to leaf path in t
 such that the sum of vertex values equals s
 https://codefights.com/interview-practice/task/TG4tEMPnAc3PnzRCs
     4
    / \
   1   3
  /   / \
 -2  1   2
   \    / \
    3  -2 -3
 */
 public class HasPathSum {
   public static void main(String[] args) {
     Node root = new Node(4);
     root.left = new Node(1);
     root.right = new Node(3);
     root.left.left = new Node(-2);
     root.left.left.right = new Node(3);
     root.right.left = new Node(1);
     root.right.right = new Node(2);
     root.right.right.left = new Node(-2);
     root.right.right.right = new Node(-3);

     /*Node root = new Node(8);
     root.right = new Node(3);*/  // sum = 8
     int sum = 6;
     boolean hasPathSum = hasPathSum(root, sum);
     System.out.println(hasPathSum);
   }

   public static boolean hasPathSum(Node root, int sum){
     if(root == null) return sum == 0; // to check base case if root is null and sum is 0
     return checkPathSum(root, sum);
   }

   private static boolean checkPathSum(Node root, int sum){
     if(root == null) return false;
     if(isLeaf(root) && root.data == sum) return true;
     return checkPathSum(root.left, sum - root.data) || checkPathSum(root.right, sum - root.data);
   }

   private static boolean isLeaf(Node node){
     return (node.left == null && node.right == null);
   }

   private static class Node{
     private int data;
     private Node left;
     private Node right;
     private Node(int val){
       this.data = val;
     }
     @Override
     public String toString(){
       return this.data + " ";
     }
   }
 }
