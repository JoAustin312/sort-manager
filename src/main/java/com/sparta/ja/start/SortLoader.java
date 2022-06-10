package com.sparta.ja.start;

import com.sparta.ja.display.DisplayManager;
import com.sparta.ja.exceptions.SorterNotFoundException;
import com.sparta.ja.logging.MyLogger;
import com.sparta.ja.sorters.Sorter;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortLoader {

    private static final Scanner scanner = new Scanner(System.in);
    private static Random r = new Random();
    private static Logger logger = MyLogger.getLogger();

    public static void start(){

        System.out.println("Enter any number except 0 to continue (0 will exit the program)");
        int cont = scanner.nextInt();
        MyLogger.getLoggerConfig();
        logger.log(Level.INFO, "Starting program");

        while (cont != 0) {
            try {
                DisplayManager.printChoices();
                int input = scanner.nextInt();
                Sorter sorter = SortManager.getSorter(input);
                DisplayManager.printChooseArraySize();
                int arraySize = scanner.nextInt();
                int[] arrayToSort = generateRandomArray(arraySize);
                DisplayManager.printResult(sorter, arrayToSort);
            } catch (SorterNotFoundException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\nEnter any number except 0 to continue (0 will exit the program)");
            cont = scanner.nextInt();
        }

    }

    private static int[] generateRandomArray(int length){
        logger.log(Level.INFO, "Generating random array with " + length + " elements");
        int[] randomArray = new int[length];

        for (int i = 0; i < length; i++){
            randomArray[i] = r.nextInt(1000) + 1; //change to user input for range
        }
        return randomArray;
    }

}
