package com.sparta.ja.sorters;

import com.sparta.ja.logging.MyLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertionSorter implements Sorter{

    private long start = 0;
    private long stop = 0;
    private static Logger logger = MyLogger.getLogger();
    @Override
    public void sortArrayVoid(int[] arr) {
        int length = arr.length;
        logger.log(Level.INFO, "Sorting array using InsertionSort");
        start = System.nanoTime();
        insertionSort(arr,length);
        stop = System.nanoTime();
    }

    @Override
    public int[] sortArray(int[] arr) {
        int length = arr.length;
        if (length > 1) {
            logger.log(Level.INFO, "Sorting array using InsertionSort");
            start = System.nanoTime();
            insertionSort(arr, length);
            stop = System.nanoTime();
            return arr;
        }
        return arr;
    }

    private static void insertionSort(int[] arr, int length){
        if (length <= 1){
            return;
        }
        insertionSort(arr, length-1);
        int key = arr[length-1];
        int pointer = length-2;

        while (pointer >= 0 && arr[pointer] > key){
            arr[pointer+1] = arr[pointer];
            pointer = pointer-1;
        }
        arr[pointer+1] = key;
    }

    @Override
    public long getTimeToSort() {
        logger.log(Level.INFO, "Calculating time to sort using InsertionSort");
        return stop - start;
    }
}
