package com.sparta.ja.sorters;

import com.sparta.ja.sorters.binarytree.BinaryTree;

public class TreeSorter implements Sorter{

    private long start = 0;
    private long stop = 0;
    @Override
    public void sortArrayVoid(int[] arr) {
        BinaryTree tree = new BinaryTree(arr);
        tree.getSortedTreeAsc();
    }

    @Override
    public int[] sortArray(int[] arr) {
        if (arr.length > 1) {
            BinaryTree tree = new BinaryTree(arr);
            start = System.nanoTime();
            int[] sortedArray = tree.getSortedTreeAsc();
            stop = System.nanoTime();
            return sortedArray;
        }
        return arr;
    }

    @Override
    public long getTimeToSort() {
        return stop - start;
    }
}
