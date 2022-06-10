package com.sparta.ja.sorters;

public class MergeSorter implements Sorter{

    private long start = 0;
    private long stop = 0;

    @Override
    public void sortArrayVoid(int[] arr) {
        int length = arr.length;
        mergeSort(arr, length);
    }

    @Override
    public int[] sortArray(int[] arr) {
        if (arr.length > 1) {
            start = System.nanoTime();
            sortArrayVoid(arr);
            stop = System.nanoTime();
        }
        return arr;
    }

    public void mergeSort(int[] arr, int arrLength) {
        if (arrLength < 2) {
            return;
        }
        int middle = arrLength / 2;
        int[] left = new int[middle];
        int[] right = new int[arrLength - middle];

        System.arraycopy(arr, 0, left, 0, middle);

        if (arrLength - middle >= 0) {
            System.arraycopy(arr, middle, right, 0, arrLength - middle);
        }

        mergeSort(left, middle);
        mergeSort(right, arrLength - middle);
        merge(arr, left, right, middle, arrLength - middle);
    }

    public static void merge(int[] arr, int[] leftArray, int[] rightArray, int leftLength, int rightLength) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            }
            else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < leftLength) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightLength) {
            arr[k++] = rightArray[j++];
        }
    }

    public static int[] mergeSortedArrays(int[] leftArray, int[] rightArray){ //previous implementation of mergeArrays updated to use new method
        if (isSorted(leftArray) && isSorted(rightArray)){
            int leftLength = leftArray.length;
            int rightLength = rightArray.length;
            int[] mergedArray = new int[leftLength + rightLength];

            merge(mergedArray, leftArray, rightArray, leftLength, rightLength);

            return mergedArray;
        } else {
            BubbleSorter bubbleSorter = new BubbleSorter();
            bubbleSorter.sortArrayVoid(leftArray); //sort arrays if given unsorted and calls method recursively
            bubbleSorter.sortArrayVoid(rightArray);
            return mergeSortedArrays(leftArray, rightArray);
        }
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    @Override
    public long getTimeToSort() {
        return stop - start;
    }

}
