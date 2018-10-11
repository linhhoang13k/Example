class MaxHeightofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
       
        if(left<right){
          return 1+right;     
        }else{
         return 1+left;
        }
        
    }
}