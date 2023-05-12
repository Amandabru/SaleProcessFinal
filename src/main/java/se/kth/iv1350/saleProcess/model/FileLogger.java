package se.kth.iv1350.saleProcess.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger {
    private static final String LOG_FILE_NAME = "sale-process-log.txt";
    private PrintWriter logFile;
    public FileLogger(){
        try {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME, true), true);
        } catch (IOException ex) {
            System.out.println("Could not create logger.");
            ex.printStackTrace();
        }
    }

    /**
     * Prints the specified string to <code>System.out</code>.
     *
     * @param message The string that will be printed to
     *
     */
    @Override
    public void log(String message) {
        logFile.println(message);
    }
}

