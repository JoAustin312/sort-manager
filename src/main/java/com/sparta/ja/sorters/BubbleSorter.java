package com.sparta.ja.sorters;

public class BubbleSorter implements Sorter{

    private static boolean swapped;

    public int[] sortArray(int[] arr){
        sortArrayVoid(arr);
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
}
