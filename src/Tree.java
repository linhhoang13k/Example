package edu.learning.codefights.tree;

//
// Definition for binary tree:
class Tree<T> {
    Tree() {}
    Tree(T x) {
        value = x;
    }
    Tree(T x, Tree<T> left, Tree<T> right) {
        value = x;
        this.left = left;
        this.right = right;
    }
    Tree(T x, Tree<T> left) {
        value = x;
        this.left = left;
    }

    T value;
    Tree<T> left;
    Tree<T> right;

    public void setValue(T value) {
        this.value = value;
    }
    public void setLeft(Tree<T> left) {
        this.left = left;
    }
    public void setRight(Tree<T> right) {
        this.right = right;
    }

    public T getValue(T value) {
        return this.value;
    }
    public Tree<T> getLeft(Tree<T> left) {
        return this.left;
    }
    public Tree<T> getRight(Tree<T> right) {
        return this.right;
    }
}