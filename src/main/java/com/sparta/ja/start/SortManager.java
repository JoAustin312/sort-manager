package com.sparta.ja.start;

import com.sparta.ja.exceptions.SorterNotFoundException;
import com.sparta.ja.sorters.BubbleSorter;
import com.sparta.ja.sorters.MergeSorter;
import com.sparta.ja.sorters.Sorter;

public class SortManager {

    public static Sorter getSorter(int input) throws SorterNotFoundException {
        switch (input){
            case 1:
                return new BubbleSorter();
            case 2:
                return new MergeSorter();
            default:
                throw new SorterNotFoundException("Sorter not found");
        }
    }

}
