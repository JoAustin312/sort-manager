package com.sparta.ja.sorters;

import com.sparta.ja.logging.MyLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSorter implements Sorter{

    private static boolean swapped;
    private long start = 0;
    private long stop = 0;
    private static Logger logger = MyLogger.getLogger();

    public int[] sortArray(int[] arr){
        if (arr.length > 1) {
            logger.log(Level.INFO, "Sorting array using BubbleSort");
            start = System.nanoTime();
            sortArrayVoid(arr);
            stop = System.nanoTime();
            return arr;
        }
        return arr;
    }

    public void sortArrayVoid(int[] arr){
        do {
            swapped = false;
            for (int i = 1; i < arr.length; i++){
                if (arr[i-1] > arr[i]){
                    swapped = true;
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                }
            }
        } while (swapped);
    }

    @Override
    public long getTimeToSort() {
        logger.log(Level.INFO, "Calculating time to sort using BubbleSort");
        return stop - start;
    }

}
