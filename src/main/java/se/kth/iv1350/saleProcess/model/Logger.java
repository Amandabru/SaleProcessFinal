package se.kth.iv1350.saleProcess.model;

/**
 * An interface for logging messages to a log. Does not handle log locations,
 * that is up to the implementing class.
 */
public interface Logger {
    /**
     * The message is printed to the log.
     *
     * @param message The message that will be logged.
     */
    void log(String message); }
