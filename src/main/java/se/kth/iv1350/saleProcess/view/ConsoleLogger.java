package se.kth.iv1350.saleProcess.view;


/**
 * Prints log messages to <code>System.out</code>.
 */
public class ConsoleLogger implements Logger {

    /**
     * Prints a string to <code>System.out</code>.
     *
     * @param message The string that will be printed to <code>System.out</code>.
     */
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
