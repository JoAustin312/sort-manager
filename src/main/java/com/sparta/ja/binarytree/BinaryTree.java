package com.sparta.ja.binarytree;

import com.sparta.ja.exceptions.ChildNotFoundException;
import com.sparta.ja.exceptions.NodeNotFoundException;
import com.sparta.ja.logging.CustomFormatter;
import com.sparta.ja.sorters.BubbleSorter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTree implements BinaryTreeInterface {

    private final Node rootNode;
    private static Logger logger = Logger.getLogger("my logger");

    public BinaryTree(final int element) {
        rootNode = new Node(element);
        try {
            Handler fileHandler = new FileHandler("src/main/java/com/sparta/ja/binarytree/BTlogs.logs", true);
            logger.addHandler(fileHandler);
            //logger.setFilter(new CustomFilter());
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        logger.log(Level.INFO, "countNodes result " + countNodes(rootNode));
        return countNodes(rootNode);
    }

    private int countNodes(Node node){
        if (node == null){
            return 0;
        }
        return 1 + countNodes(node.getLeftChild()) + countNodes(node.getRightChild());
    }

    @Override
    public void addElements(int[] elements) {
        addMultipleNodesToTree(rootNode, elements);
    }

    private void addMultipleNodesToTree(Node node, int[] elementsArray){
        for (int element : elementsArray){
            addNodeToTree(node, element);
        }
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        if (findElement(element)) {
            Node node = findNode(element);
            if (node.hasLeftChild()) {
                Node leftChild = getLeftChild(node);
                return leftChild.getValue();
            } else throw new ChildNotFoundException("Child not found");
        } else throw new ChildNotFoundException("Node not found");
    }

    private Node getLeftChild(Node node){
        if (node.hasLeftChild()){
            return node.getLeftChild();
        } else return null;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException, NodeNotFoundException {
        if (findElement(element)) {
            Node node = findNode(element);
            if (node.hasRightChild()) {
                Node rightChild = getRightChild(node);
                return rightChild.getValue();
            } else throw new ChildNotFoundException("Child not found");
        } else throw new NodeNotFoundException("Node not found");
    }

    private Node getRightChild(Node node) {
        if (node.hasRightChild()){
            return node.getRightChild();
        } else return null;
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] elementsArray = getSortedTreeAsc(rootNode).stream().mapToInt(i -> i).toArray();
        BubbleSorter.bubbleSortVoid(elementsArray);
        return elementsArray;
    }

    private ArrayList<Integer> getSortedTreeAsc(Node node) {
        if (node == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> elements = new ArrayList<>();
        elements.add(node.getValue());
        elements.addAll(getSortedTreeAsc(node.getLeftChild()));
        elements.addAll(getSortedTreeAsc(node.getRightChild()));

        return elements;
    }

    @Override
    public int[] getSortedTreeDesc() {
        return new int[0];
    }
}
