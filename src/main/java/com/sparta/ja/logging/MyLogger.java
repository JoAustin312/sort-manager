package com.sparta.ja.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {

    private static Logger logger = Logger.getLogger("my logger");

    public static void getLoggerConfig() {
        try {
            Handler fileHandler = new FileHandler("src/main/java/com/sparta/ja/logging/myLog.log", true);
            logger.addHandler(fileHandler);
            //logger.setFilter(new CustomFilter());
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.setLevel(Level.INFO);
//        logger.log(Level.INFO, "This is an information message");
//        logger.log(Level.CONFIG, "This is a config message");
//        logger.log(Level.FINE, "This is an fine message");
//        logger.log(Level.WARNING, "This is a warning message, hello warnings");
    }

    public static Logger getLogger(){
        return logger;
    }
}