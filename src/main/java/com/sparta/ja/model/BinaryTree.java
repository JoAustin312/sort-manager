package com.sparta.ja.model;

public class BinaryTree implements BinaryTreeInterface {

    private final Node rootNode;

    public BinaryTree(final int element) {
        rootNode = new Node(element);
    }

    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
    }

    private void addNodeToTree(Node node, int element){
        if (element < node.getValue()){
            if (!node.hasLeftChild()){
                Node leftChild = new Node(element);
                node.setLeftChild(leftChild);
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()){
            if (!node.hasRightChild()){
                Node rightChild = new Node(element);
                node.setRightChild(rightChild);
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    @Override
    public boolean findElement(final int element) {
        Node node = findNode(element);
        return node != null;
    }

    private Node findNode(final int element){
        Node node = rootNode;
        while(node != null){
            if (element == node.getValue()){
                return node;
            }
            if (element < node.getValue()){
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }


    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return 0;
    }



    @Override
    public void addElements(int[] elements) {

    }



    @Override
    public int getLeftChild(int element) { //throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int getRightChild(int element) { //throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        return new int[0];
    }

    @Override
    public int[] getSortedTreeDesc() {
        return new int[0];
    }
}
