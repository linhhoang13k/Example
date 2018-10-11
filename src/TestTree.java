package com.sleepsoft.tests;

/**
 * Created by agermenos on 6/23/16.
 */
public class TestTree {
    public boolean testSubtree(Node mainTree, Node subTree) {
        //Asumming built a couple of trees
        boolean currentValue=true;
        currentValue = subTree.id.equals(mainTree.id);
        // If the main doesn't have children and the subtree has, it should fail
        if ((mainTree.leftNode!=null && subTree.leftNode==null) ||
                (mainTree.rightNode!=null && subTree.rightNode==null)) {
            currentValue=false;
        }
        if (currentValue==true && (subTree.leftNode!=null || subTree.rightNode!=null)) {

            if (subTree.leftNode!=null) {
                currentValue = testSubtree(mainTree.leftNode, subTree.leftNode);
                if (currentValue==true && subTree.rightNode!=null) {
                    testSubtree (mainTree.rightNode, subTree.rightNode);
                }
            }
        }
        return currentValue;
    }

    public Node findCandidateNode(Node mainTree, Integer id) {
        Node returnNode=null;
        if (mainTree.id.equals(id)) {
            returnNode = mainTree;
        }
        if (returnNode==null && mainTree.leftNode!=null) {
            returnNode = findCandidateNode (mainTree.leftNode, id);
        }
        if (returnNode==null && mainTree.rightNode!=null) {
            returnNode = findCandidateNode (mainTree.rightNode, id);
        }
        return returnNode;
    }

    public static void main(String args[]) {
        TestTree testTree = new TestTree();
        Node mainTree = testTree.buildMainTree();
        Node subTree = testTree.buildSecondNode();
        Node candidateNode = null;
        do {
            candidateNode = testTree.findCandidateNode(mainTree, subTree.id);
            if (candidateNode!=null) {
                System.out.println("Test for child tree is " + testTree.testSubtree(candidateNode, subTree));
            }
        } while (candidateNode!=null);
    }

    private Node buildMainTree() {
        return new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
    }

    private Node buildSecondNode() {
        return new Node(3, new Node(6), new Node(7));
    }

}


