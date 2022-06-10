package com.sparta.ja;

import com.sparta.ja.sorters.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortTester {

    private final int[] arrayToSort50 = {330, 264, 510, 821, 577, 282, 511, 848, 177, 229, 171, 149, 737, 491, 616, 39, 994, 312, 3, 368, 298, 640, 866, 380, 484, 947, 880, 501, 4, 662, 737,
            635, 528, 335, 717, 208, 451, 13, 138, 221, 227, 753, 705, 685, 938, 461, 683, 740, 545, 71};
    private final int[] expected50 = {3, 4, 13, 39, 71, 138, 149, 171, 177, 208, 221, 227, 229, 264, 282, 298, 312, 330, 335, 368, 380, 451, 461, 484, 491, 501, 510, 511, 528, 545, 577, 616,
            635, 640, 662, 683, 685, 705, 717, 737, 737, 740, 753, 821, 848, 866, 880, 938, 947, 994};
    private final int[] arrayToSort100 = {370, 294, 633, 488, 712, 732, 416, 932, 62, 813, 428, 888, 833, 19, 676, 57, 614, 212, 247, 510, 344, 252, 415, 194, 850, 908, 923, 429, 166, 767,
            826, 717, 704, 229, 619, 740, 261, 550, 906, 983, 917, 452, 245, 763, 815, 765, 428, 324, 940, 252, 143, 291, 755, 283, 521, 859, 332, 887, 962, 592, 504, 160, 275, 52, 413,
            92, 658, 143, 64, 519, 678, 907, 411, 1000, 716, 194, 310, 163, 7, 572, 617, 630, 191, 544, 392, 235, 888, 782, 623, 97, 187, 135, 380, 503, 289, 106, 69, 591, 500, 524};
    private final int[] expected100 = {7, 19, 52, 57, 62, 64, 69, 92, 97, 106, 135, 143, 143, 160, 163, 166, 187, 191, 194, 194, 212, 229, 235, 245, 247, 252, 252, 261, 275, 283, 289, 291,
            294, 310, 324, 332, 344, 370, 380, 392, 411, 413, 415, 416, 428, 428, 429, 452, 488, 500, 503, 504, 510, 519, 521, 524, 544, 550, 572, 591, 592, 614, 617, 619, 623, 630, 633,
            658, 676, 678, 704, 712, 716, 717, 732, 740, 755, 763, 765, 767, 782, 813, 815, 826, 833, 850, 859, 887, 888, 888, 906, 907, 908, 917, 923, 932, 940, 962, 983, 1000};
    private final int[] arrayToSort50Dupes = {330, 264, 510, 821, 577, 282, 511, 848, 177, 229, 177, 149, 737, 491, 616, 39, 994, 312, 4, 380, 298, 640, 866, 380, 484, 947, 880, 510, 4, 662,
            737, 635, 528, 335, 737, 208, 451, 13, 138, 221, 227, 753, 705, 685, 947, 461, 683, 740, 545, 71};
    private final int[] expected50Dupes = {4, 4, 13, 39, 71, 138, 149, 177, 177, 208, 221, 227, 229, 264, 282, 298, 312, 330, 335, 380, 380, 451, 461, 484, 491, 510, 510, 511, 528, 545, 577,
            616, 635, 640, 662, 683, 685, 705, 737, 737, 737, 740, 753, 821, 848, 866, 880, 947, 947, 994};

    private final int[] arrayToSort1 = {4};
    private final int[] expected1 = {4};
    private final int[] arrayToSort0 = {};
    private final int[] expected0 = {};



    @Test
    @DisplayName("Test bubble sort is sorting array of length 50")
    void testBubbleSortIsSortingArray50(){
        Sorter sorter = new BubbleSorter();
        sorter.sortArrayVoid(arrayToSort50);
        assertArrayEquals(expected50, arrayToSort50);
    }

    @Test
    @DisplayName("Test bubble sort is sorting array of length 100")
    void testBubbleSortIsSortingArray100(){
        Sorter sorter = new BubbleSorter();
        sorter.sortArrayVoid(arrayToSort100);
        assertArrayEquals(expected100, arrayToSort100);
    }

    @Test
    @DisplayName("Test bubble sort is sorting array of length 50 with duplicates")
    void testBubbleSortIsSortingArray50Dupe(){
        Sorter sorter = new BubbleSorter();
        sorter.sortArrayVoid(arrayToSort50Dupes);
        assertArrayEquals(expected50Dupes, arrayToSort50Dupes);
    }

    @Test
    @DisplayName("Test bubble sort is returning an array of length 1")
    void testBubbleSortIsReturningArray1(){
        Sorter sorter = new BubbleSorter();
        sorter.sortArrayVoid(arrayToSort1);
        assertArrayEquals(expected1, arrayToSort1);
    }

    @Test
    @DisplayName("Test bubble sort is returning an empty array")
    void testBubbleSortIsReturningEmptyArray(){
        Sorter sorter = new BubbleSorter();
        sorter.sortArrayVoid(arrayToSort0);
        assertArrayEquals(expected0, arrayToSort0);
    }

    @Test
    @DisplayName("Test merge sort is sorting array of length 50")
    void testMergeSortIsSortingArray50(){
        Sorter sorter = new MergeSorter();
        sorter.sortArrayVoid(arrayToSort50);
        assertArrayEquals(expected50, arrayToSort50);
    }

    @Test
    @DisplayName("Test merge sort is sorting array of length 100")
    void testMergeSortIsSortingArray100(){
        Sorter sorter = new MergeSorter();
        sorter.sortArrayVoid(arrayToSort100);
        assertArrayEquals(expected100, arrayToSort100);
    }

    @Test
    @DisplayName("Test merge sort is sorting array of length 50 with duplicates")
    void testMergeSortIsSortingArray50Dupe(){
        Sorter sorter = new MergeSorter();
        sorter.sortArrayVoid(arrayToSort50Dupes);
        assertArrayEquals(expected50Dupes, arrayToSort50Dupes);
    }

    @Test
    @DisplayName("Test merge sort is returning an array of length 1")
    void testMergeSortIsReturningArray1(){
        Sorter sorter = new MergeSorter();
        sorter.sortArrayVoid(arrayToSort1);
        assertArrayEquals(expected1, arrayToSort1);
    }

    @Test
    @DisplayName("Test merge sort is returning an empty array")
    void testMergeSortIsReturningEmptyArray(){
        Sorter sorter = new MergeSorter();
        sorter.sortArrayVoid(arrayToSort0);
        assertArrayEquals(expected0, arrayToSort0);
    }

    @Test
    @DisplayName("Test insertion sort is sorting array of length 50")
    void testInsertionSortIsSortingArray50(){
        Sorter sorter = new InsertionSorter();
        sorter.sortArrayVoid(arrayToSort50);
        assertArrayEquals(expected50, arrayToSort50);
    }

    @Test
    @DisplayName("Test insertion sort is sorting array of length 100")
    void testInsertionSortIsSortingArray100(){
        Sorter sorter = new InsertionSorter();
        sorter.sortArrayVoid(arrayToSort100);
        assertArrayEquals(expected100, arrayToSort100);
    }

    @Test
    @DisplayName("Test insertion sort is sorting array of length 50 with duplicates")
    void testInsertionSortIsSortingArray50Dupe(){
        Sorter sorter = new InsertionSorter();
        sorter.sortArrayVoid(arrayToSort50Dupes);
        assertArrayEquals(expected50Dupes, arrayToSort50Dupes);
    }

    @Test
    @DisplayName("Test insertion sort is returning an array of length 1")
    void testInsertionSortIsReturningArray1(){
        Sorter sorter = new InsertionSorter();
        sorter.sortArrayVoid(arrayToSort1);
        assertArrayEquals(expected1, arrayToSort1);
    }

    @Test
    @DisplayName("Test insertion sort is returning an empty array")
    void testInsertionSortIsReturningEmptyArray(){
        Sorter sorter = new InsertionSorter();
        sorter.sortArrayVoid(arrayToSort0);
        assertArrayEquals(expected0, arrayToSort0);
    }

    @Test
    @DisplayName("Test tree sort is sorting array of length 50")
    void testTreeSortIsSortingArray50(){
        Sorter sorter = new TreeSorter();
        assertArrayEquals(expected50, sorter.sortArray(arrayToSort50));
    }

    @Test
    @DisplayName("Test tree sort is sorting array of length 100")
    void testTreeSortIsSortingArray100(){
        Sorter sorter = new TreeSorter();
        assertArrayEquals(expected100, sorter.sortArray(arrayToSort100));
    }

    @Test
    @DisplayName("Test tree sort is sorting array of length 50 with duplicates")
    void testTreeSortIsSortingArray50Dupe(){
        Sorter sorter = new TreeSorter();
        assertArrayEquals(expected50Dupes, sorter.sortArray(arrayToSort50Dupes));
    }

    @Test
    @DisplayName("Test tree sort is returning an array of length 1")
    void testTreeSortIsReturningArray1(){
        Sorter sorter = new TreeSorter();
        assertArrayEquals(expected1, sorter.sortArray(arrayToSort1));
    }

    @Test
    @DisplayName("Test tree sort is returning an empty array")
    void testTreeSortIsReturningEmptyArray(){
        Sorter sorter = new TreeSorter();
        assertArrayEquals(expected0, sorter.sortArray(arrayToSort0));
    }

}
