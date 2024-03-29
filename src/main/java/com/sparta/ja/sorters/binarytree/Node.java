package com.sparta.ja.sorters.binarytree;

public class Node {
    private final int value;
    private Node leftChild;
    private Node rightChild;
    public Node(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public Node getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
    public Node getRightChild() {
        return rightChild;
    }
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    public boolean hasLeftChild(){
        return leftChild != null;
    }
    public boolean hasRightChild(){
        return rightChild != null;
    }
}
