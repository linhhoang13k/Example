package com.sleepsoft.tests;

/**
 * Created by Alejandro on 6/25/16.
 */
public class SubTreeChecker {
    public static void main(String args[]){
        Node mainTree = new Node(1, new Node(2,
                new Node(4, new Node (8), new Node(9)), new Node (3, new Node(10),
                        new Node (11))), new Node (3, new Node (6, new Node (12),
                new Node(13)), new Node (7, new Node (14), new Node (15))));
        Node subTree = new Node(3, new Node(6), new Node(7));

        System.out.println("Starting search for subtree in mainTree...");
        SubTreeChecker subTreeChecker = new SubTreeChecker();
        subTreeChecker.checkSubTree(mainTree, subTree);
    }

    private void checkSubTree(Node mainTree, Node subTree) {
        //Search for node that's same in subTree than in mainTree
        System.out.println("Checking " + mainTree.id);
        if (mainTree.id.equals(subTree.id)) {
            System.out.println ("Node " +  subTree.id +
                    " found in mainTree... is equal? " + checkSameBranch(mainTree, subTree));
        }
        if (mainTree.leftNode!=null) {
            checkSubTree(mainTree.leftNode, subTree);
        }
        if (mainTree.rightNode!=null) {
            checkSubTree(mainTree.rightNode, subTree);
        }
        return;
    }

    private boolean checkSameBranch(Node mainTree, Node subTree) {
        boolean areTheSame = mainTree.id.equals(subTree.id);
        if (areTheSame && mainTree.leftNode!=null && subTree.leftNode!=null) {
            areTheSame = checkSameBranch(mainTree.leftNode, subTree.leftNode);
        }
        if (areTheSame && mainTree.rightNode!=null && subTree.rightNode!=null) {
            areTheSame = checkSameBranch(mainTree.rightNode, subTree.rightNode);
        }
        return areTheSame;
    }
}
