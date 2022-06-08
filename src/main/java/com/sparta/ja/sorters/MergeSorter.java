package com.sparta.ja.sorters;

public class MergeSorter {

    public static int[] mergeArrays(int[] firstArray, int[] secondArray){
        if (isSorted(firstArray) && isSorted(secondArray)){
            int firstArrayLength = firstArray.length;
            int secondArrayLength = secondArray.length;
            int firstArrayPointer = 0;
            int secondArrayPointer = 0;
            int mergedArrayPointer = 0;

            int[] mergedArray = new int[firstArrayLength + secondArrayLength];


            while (firstArrayPointer < firstArrayLength && secondArrayPointer < secondArrayLength){ //merge arrays while arrays both have values
                if (firstArray[firstArrayPointer] < secondArray[secondArrayPointer]){
                    mergedArray[mergedArrayPointer++] = firstArray[firstArrayPointer++];
                } else {
                    mergedArray[mergedArrayPointer++] = secondArray[secondArrayPointer++];
                }
            }

            while (firstArrayPointer < firstArrayLength){ //adds remaining values to array if firstArray is longer
                mergedArray[mergedArrayPointer++] = firstArray[firstArrayPointer++];
            }

            while (secondArrayPointer < secondArrayLength){ //adds remaining values to array if secondArray is longer
                mergedArray[mergedArrayPointer++] = secondArray[secondArrayPointer++];
            }
            return mergedArray;
        } else {
            BubbleSorter.bubbleSortVoid(firstArray); //sort arrays if given unsorted and calls method recursively
            BubbleSorter.bubbleSortVoid(secondArray);
            return mergeArrays(firstArray, secondArray);
        }
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}
