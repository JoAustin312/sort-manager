package com.sparta.ja.display;

import com.sparta.ja.logging.MyLogger;
import com.sparta.ja.sorters.Sorter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayManager {

    private static Logger logger = MyLogger.getLogger();

    public static void printChoices(){
        logger.log(Level.INFO, "Printing choices to user");
        System.out.println("Please choose a sorter by entering the corresponding value below: \n" +
                "1: Bubble Sort\n" +
                "2: Merge Sort\n" +
                "3: Insertion Sort\n" +
                "4: Tree Sort");
    }

    public static void printChooseArraySize(){
        logger.log(Level.INFO, "Printing array size message to user");
        System.out.println("Please enter a number for the size of the array to be generated");
    }

    public static void printResult(Sorter sorter, int[] arr){
        logger.log(Level.INFO, "Printing results to user");
        System.out.println("\n ---------- RESULTS ---------- \n" +
                "\nUnsorted Array: \n" + Arrays.toString(arr) + "\n" +
                "\nArray after using " + sorter.getClass().getSimpleName() + ":");
        int[] sortedArray = sorter.sortArray(arr);
        System.out.println(Arrays.toString(sortedArray) +
                "\n\nTime taken to sort: " + sorter.getTimeToSort() + " ns" +
                "\n\n---------- END ----------");

    }


}
