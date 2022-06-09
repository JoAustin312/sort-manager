package com.sparta.ja.sorters;

public class BubbleSorter implements Sorter{

    private static boolean swapped;
    private long start = 0;
    private long stop = 0;

    public int[] sortArray(int[] arr){
        start = System.nanoTime();
        sortArrayVoid(arr);
        stop = System.nanoTime();
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
        return start - stop;
    }

}
