package se.kth.iv1350.saleProcess.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Responsible for printing log messages to a file. The log file resides in the current
 * directory and is named sale-process-log.txt
 */
public class FileLogger implements Logger {
    private static final String LOG_FILE_NAME = "sale-process-log.txt";
    private PrintWriter logFile;

    /**
     * Creates a new instance of the <code>FileLogger</code>. Creates the log file as well.
     */
    public FileLogger(){
        try {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME, true), true);
        } catch (IOException ex) {
            System.out.println("Could not create logger.");
            ex.printStackTrace();
        }
    }

    /**
     * Prints the string to the log file.
     *
     * @param message The string that will be printed to the log file.
     *
     */
    @Override
    public void log(String message) {
        logFile.println(message);
    }
}

