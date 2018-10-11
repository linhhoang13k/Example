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
class TraverseTree{
int[] traverseTree(Tree<Integer> t) {
    Queue<Tree<Integer>> queue = new LinkedList<Tree<Integer>>();
    List<Integer> result = new ArrayList<Integer>();
    if(t != null)
        queue.add(t);
    while(!queue.isEmpty()){
        Tree<Integer> root = queue.poll();
        result.add(root.value);
        if(root.left != null)
            queue.add(root.left);
        if(root.right != null)
            queue.add(root.right);
    }
    return result.stream().mapToInt((Integer i) -> i.intValue()).toArray();
}
}
