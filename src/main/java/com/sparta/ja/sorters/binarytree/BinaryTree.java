package com.sparta.ja.sorters.binarytree;

import com.sparta.ja.exceptions.ChildNotFoundException;
import com.sparta.ja.exceptions.NodeNotFoundException;
import com.sparta.ja.logging.MyLogger;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTree implements BinaryTreeInterface {

    private final Node rootNode;
    private int[] sortedElements;
    private static Logger logger = MyLogger.getLogger();
    private static long stop = 0;
    private static long start = 0;

    public BinaryTree(final int element) {
        logger.log(Level.INFO, "Creating binary tree with only root node");
        rootNode = new Node(element);
    }
    public BinaryTree(int[] arr) {
        logger.log(Level.INFO, "Creating binary tree with with given array: " + Arrays.toString(arr));
        rootNode = new Node(arr[0]);
        addMultipleNodesToTree(rootNode, arr);
    }
    public BinaryTree(final int element, int[] arr) {
        logger.log(Level.INFO, "Creating binary tree with with given array: " + Arrays.toString(arr) + " and given root node: " + element);
        rootNode = new Node(element);
        addMultipleNodesToTree(rootNode,arr);
    }

    @Override
    public void addElement(final int element) {
        logger.log(Level.INFO, "Adding element \"" + element +"\" to tree");
        addNodeToTree(rootNode, element);
    }

    private void addNodeToTree(Node node, int element){
        if (element <= node.getValue()){
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
        logger.log(Level.INFO, "Finding element \"" + element +"\" in tree");
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
        logger.log(Level.INFO, "Getting current root node in tree");
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        logger.log(Level.INFO, "Getting number of elements in tree");
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
        for (int i = 1; i < elementsArray.length; i++){
            addNodeToTree(node, elementsArray[i]);
        }
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException, NodeNotFoundException {
        if (findElement(element)) {
            Node node = findNode(element);
            if (node.hasLeftChild()) {
                Node leftChild = getLeftChild(node);
                return leftChild.getValue();
            } else {
                logger.log(Level.INFO, "ChildNotFoundException thrown");
                throw new ChildNotFoundException("Child not found");
            }
        } else {
            logger.log(Level.INFO, "NodeNotFoundException thrown");
            throw new NodeNotFoundException("Node not found");
        }
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
            } else {
                logger.log(Level.INFO, "ChildNotFoundException thrown");
                throw new ChildNotFoundException("Child not found");
            }
        } else {
            logger.log(Level.INFO, "NodeNotFoundException thrown");
            throw new NodeNotFoundException("Node not found");
        }
    }

    private Node getRightChild(Node node) {
        if (node.hasRightChild()){
            return node.getRightChild();
        } else return null;
    }

    @Override
    public int[] getSortedTreeAsc() {
        sortedElements = new int[0];
        start = System.nanoTime();
        getSortedTreeAsc(rootNode);
        stop = System.nanoTime();
        return sortedElements;
    }

    private void getSortedTreeAsc(Node node) {
        if (node == null){
            return;
        }
        if (node.hasLeftChild()){
            getSortedTreeAsc(node.getLeftChild());
        }
        sortedElements = appendToArray(sortedElements, node.getValue());
        if (node.hasRightChild()) {
            getSortedTreeAsc(node.getRightChild());
        }
    }

    @Override
    public int[] getSortedTreeDesc() {
        sortedElements = new int[0];
        start = System.nanoTime();
        getSortedTreeDesc(rootNode);
        stop = System.nanoTime();
        return sortedElements;
    }

    private void getSortedTreeDesc(Node node) {
        if (node == null){
            return;
        }
        if (node.hasRightChild()) {
            getSortedTreeDesc(node.getRightChild());
        }
        sortedElements = appendToArray(sortedElements, node.getValue());
        if (node.hasLeftChild()){
            getSortedTreeDesc(node.getLeftChild());
        }
    }

    private int[] appendToArray(int[] arr, int numToAppend){
        int[] result = new int[arr.length + 1];
        System.arraycopy(arr, 0, result, 0, arr.length);
        result[result.length - 1] = numToAppend;
        return result;
    }

    public static long getTimeToSort() {
        logger.log(Level.INFO, "Calculating time to sort using TreeSort");
        return stop - start;
    }


}
