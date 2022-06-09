package com.sparta.ja.display;

import com.sparta.ja.sorters.Sorter;

import java.util.Arrays;

public class DisplayManager {

    public static void printChoices(){
        System.out.println("Please choose a sorter by entering the corresponding value below: \n" +
                "1: Bubble Sort\n" +
                "2: Merge Sort\n" +
                "3: Insertion Sort" +
                "4: ");
    }

    public static void printChooseArraySize(){
        System.out.println("Please enter a number for the size of the array to be generated");
    }

    public static void printResult(Sorter sorter, int[] arr){
        System.out.println("\n ---------- RESULTS ---------- \n" +
                "\nUnsorted Array: \n" + Arrays.toString(arr) + "\n" +
                "\nArray after using " + sorter.getClass().getSimpleName() + ":");
        int[] sortedArray = sorter.sortArray(arr);
        System.out.println(Arrays.toString(sortedArray) +
                "\n\nTime taken to sort: " + sorter.getTimeToSort() + " ns" +
                "\n\n---------- END ----------");

    }


}
