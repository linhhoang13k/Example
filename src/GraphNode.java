package TreeNode;

/**
 * Created by Trung on 6/3/2017.
 */
public class GraphNode<E> {

    private E data;

    private E next;

    public GraphNode() {
        data = (E) new Object();
    }

    public GraphNode(E theData) {
        data = theData;
    }


}
