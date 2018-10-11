//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
int kthSmallestInBST(Tree<Integer> t, int k) {
    List<Integer> arr = new ArrayList<Integer>();
    
    arr = createArray(t, arr);
    
    return arr.get(k-1);
}

List<Integer> createArray(Tree<Integer> root, List<Integer> arr) {
    
    if(root.left != null) {
        createArray(root.left, arr);
    }
    
    arr.add(root.value);

    if(root.right != null) {
        createArray(root.right, arr);
    }
    
    return arr;
    
    
    
}
