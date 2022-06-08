package com.sparta.ja.sorters;

public class BubbleSorter {

    private static boolean swapped;

    public BubbleSorter() {
    }

    public static int[] bubbleSortArray(int[] arr){
        bubbleSortVoid(arr);
        return arr;
    }

    public static void bubbleSortVoid(int[] arr){
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
