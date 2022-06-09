package com.sparta.ja.start;

import com.sparta.ja.exceptions.SorterNotFoundException;
import com.sparta.ja.sorters.*;

public class SortManager {

    public static Sorter getSorter(int input) throws SorterNotFoundException {
        switch (input){
            case 1:
                return new BubbleSorter();
            case 2:
                return new MergeSorter();
            case 3:
                return new InsertionSorter();
            case 4:
                return new TreeSorter();
            default:
                throw new SorterNotFoundException("Sorter not found");
        }
    }

}
