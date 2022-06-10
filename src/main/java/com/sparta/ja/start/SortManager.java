package com.sparta.ja.start;

import com.sparta.ja.exceptions.SorterNotFoundException;
import com.sparta.ja.logging.MyLogger;
import com.sparta.ja.sorters.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SortManager {

    private static Logger logger = MyLogger.getLogger();

    public static Sorter getSorter(int input) throws SorterNotFoundException {
        switch (input){
            case 1:
                logger.log(Level.INFO, "Returning BubbleSorter object from factory");
                return new BubbleSorter();
            case 2:
                logger.log(Level.INFO, "Returning MergeSorter object from factory");
                return new MergeSorter();
            case 3:
                logger.log(Level.INFO, "Returning InsertionSorter object from factory");
                return new InsertionSorter();
            case 4:
                logger.log(Level.INFO, "Returning TreeSorter object from factory");
                return new TreeSorter();
            default:
                logger.log(Level.INFO, "SorterNotFoundException thrown");
                throw new SorterNotFoundException("Sorter not found");
        }
    }

}
