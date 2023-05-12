package se.kth.iv1350.saleProcess.Integration;

/**
 * The exception for when the calling of the database fails.
 */
public class DataBaseException extends RuntimeException {

    /**
     * Creates a new instance of the exception, with a message about
     * the cause of the exception.
     * @param msg
     */
    public DataBaseException(String msg) {
        super(msg);
    }
}