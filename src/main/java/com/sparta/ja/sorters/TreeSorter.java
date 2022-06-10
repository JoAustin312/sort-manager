package com.sparta.ja.sorters;

import com.sparta.ja.logging.MyLogger;
import com.sparta.ja.sorters.binarytree.BinaryTree;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TreeSorter implements Sorter{

    private long start = 0;
    private long stop = 0;
    private static Logger logger = MyLogger.getLogger();

    @Override
    public void sortArrayVoid(int[] arr) {
        if (arr.length > 1) {
            BinaryTree tree = new BinaryTree(arr);
            logger.log(Level.INFO, "Sorting array using TreeSort");
            start = System.nanoTime();
            tree.getSortedTreeAsc();
            stop = System.nanoTime();
        }
    }

    @Override
    public int[] sortArray(int[] arr) {
        if (arr.length > 1) {
            BinaryTree tree = new BinaryTree(arr);
            logger.log(Level.INFO, "Sorting array using TreeSort");
            start = System.nanoTime();
            int[] sortedArray = tree.getSortedTreeAsc();
            stop = System.nanoTime();
            return sortedArray;
        }
        return arr;
    }

    @Override
    public long getTimeToSort() {
        logger.log(Level.INFO, "Calculating time to sort using TreeSort");
        return BinaryTree.getTimeToSort();
    }
}
