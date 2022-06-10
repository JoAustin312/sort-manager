package com.sparta.ja;

import com.sparta.ja.display.DisplayManager;
import com.sparta.ja.sorters.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class PerformanceTester {

    private int[] unsortedArray;
    private static int[] arrayToSort;

    @BeforeAll
    public static void arraySetup(){
        Random r = new Random();
        arrayToSort = new int[100];
        for (int i = 0; i < arrayToSort.length; i++){
            arrayToSort[i] = r.nextInt(1000)+1;
        }
    }

    @BeforeEach
    public void copyArray(){
        unsortedArray = arrayToSort.clone();
    }

    @Test
    @DisplayName("Performance test for bubble sort")
    void bubbleSortPerformanceTest(){
        Sorter sorter = new BubbleSorter();
        DisplayManager.printResult(sorter, unsortedArray);
    }

    @Test
    @DisplayName("Performance test for merge sort")
    void mergeSortPerformanceTest(){
        Sorter sorter = new MergeSorter();
        DisplayManager.printResult(sorter, unsortedArray);
    }

    @Test
    @DisplayName("Performance test for insertion sort")
    void insertionSortPerformanceTest(){
        Sorter sorter = new TreeSorter();
        DisplayManager.printResult(sorter, unsortedArray);
    }

    @Test
    @DisplayName("Performance test for tree sort")
    void treeSortPerformanceTest(){
        Sorter sorter = new InsertionSorter();
        DisplayManager.printResult(sorter, unsortedArray);
    }
}
