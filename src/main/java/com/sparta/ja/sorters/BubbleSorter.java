package com.sparta.ja.sorters;

public class BubbleSorter {

    public BubbleSorter() {
    }

    public static int[] bubbleSortArray(int[] arr){
        int arrLength = arr.length;
        int[] sortedArray = new int[arrLength];
        bubbleSortVoid(sortedArray);
        return sortedArray;
    }

    public static void bubbleSortVoid(int[] arr){
        int n = arr.length;
        int tempNum = 0;
        if (arr.length > 0) { //not sure if this check is necessary
            for (int i = 0; i < n; i++){
                for (int j = 1; j < (n-i); j++){
                    if (arr[j-1] > arr[j]){
                        tempNum = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = tempNum;
                    }
                }
            }
        }
    }
}
