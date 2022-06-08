package com.sparta.ja.control;

import com.sparta.ja.binarytree.BinaryTree;
import com.sparta.ja.exceptions.ChildNotFoundException;
import com.sparta.ja.exceptions.NodeNotFoundException;
import com.sparta.ja.sorters.MergeSorter;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        BinaryTree tree = new BinaryTree(20);
        tree.addElement(25);
        tree.addElement(11);
        tree.addElement(89);
        tree.addElement(47);
        tree.addElement(3);
        tree.addElement(64);
        tree.addElement(112);

        //System.out.println(tree.findElement(89));
        //System.out.println(tree.getNumberOfElements());

        int[] elementsToAdd = {4,56,35,71,95};
        tree.addElements(elementsToAdd);
        //System.out.println(tree.getNumberOfElements());

//        try {
//            System.out.println(tree.getRightChild(25));
//            System.out.println(tree.getRightChild(64));
//            System.out.println(tree.getRightChild(47));
//            //System.out.println(tree.getRightChild(112));
//        } catch (ChildNotFoundException | NodeNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            System.out.println(tree.getLeftChild(20));
//            System.out.println(tree.getLeftChild(89));
//            System.out.println(tree.getLeftChild(47));
//            System.out.println(tree.getLeftChild(112));
//        } catch (ChildNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(Arrays.toString(tree.getSortedTreeAsc()));
        System.out.println(Arrays.toString(tree.getSortedTreeDesc()));

        int[] arrayToSort = {4,56,35,71,95,31,78,62,6,90,120,104,1};
        MergeSorter mergeSorter = new MergeSorter();
        System.out.println(Arrays.toString(mergeSorter.sortArray(arrayToSort)));
    }
}
