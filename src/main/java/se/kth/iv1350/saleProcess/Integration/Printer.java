package se.kth.iv1350.saleProcess.Integration;


import se.kth.iv1350.saleProcess.model.Receipt;

/**
 * A representation for the system which would handle calls to the printer that has not yet been implemented.
 */
public class Printer {

	/**
	 * Prints the receipt to <code>System.out</code>
	 * @param receipt the receipt containing information about a sale
	 */
	public void printReceipt(Receipt receipt) {
		System.out.println(receipt.createReceiptString());
	}

}
