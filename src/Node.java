package com.sleepsoft.tests;

/**
 * Created by Alejandro on 6/25/16.
 */
public class Node {
    Integer id;
    Node leftNode;
    Node rightNode;

    Node(){
        super();
    }

    Node (Integer id){
        this.id = id;
    }

    Node (Integer id, Node leftNode, Node rightNode){
       this.id = id;
        this.leftNode=leftNode;
        this.rightNode=rightNode;
    }
}
