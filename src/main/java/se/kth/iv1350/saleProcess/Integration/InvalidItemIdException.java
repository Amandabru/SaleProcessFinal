package se.kth.iv1350.saleProcess.Integration;

/**
 * The exception for when trying to access an invalid item from the inventory.
 */
public class InvalidItemIdException extends Exception {
    /**
     * Creates a new instance of the exception, with a message about
     * the cause of the exception and the invalid item id.
     * @param msg
     */
    public InvalidItemIdException(String msg) {
        super(msg);
    }
}

