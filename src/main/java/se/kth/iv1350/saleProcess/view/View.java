package se.kth.iv1350.saleProcess.view;


import se.kth.iv1350.saleProcess.Integration.InvalidItemIdException;
import se.kth.iv1350.saleProcess.Integration.ItemDTO;
import se.kth.iv1350.saleProcess.controller.Controller;
import se.kth.iv1350.saleProcess.model.AddedItemInformation;
import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * Class representing the view of the program. It is a placeholder with hard coded calls to operations
 * in the controller.
 */
public class View {
	private final Controller contr;
	private Logger logger;
	private FileLogger fileLogger = new FileLogger();
	private ConsoleLogger consoleLogger = new ConsoleLogger();

	/**
	 * Creates a new instance
	 * @param contr the controller
	 */
	public View(Controller contr) {
		this.contr = contr;
		contr.addSaleObserver(new TotalRevenueFileOutput());
		contr.addSaleObserver(new TotalRevenueView());
	}
	private void setLogger(Logger logger) { this.logger = logger;
	}

	/**
	 * Creates a readable string from the information about the newly added item and prints it to the console
	 */
	public void printAddedItem(AddedItemInformation addedItem) {
		ItemDTO item = addedItem.getLineItem().getItem();
		System.out.println(String.format("Item: %s \nDescription: %s \nPrice/unit: %s \nQuantity: %s\nRunning Total: %s\n",
				item.getName(), item.getItemDescription(), item.getPriceIncludingTax().toString(), addedItem.getLineItem().getQuantity(),
				addedItem.getRunningTotalIncludingTax().toString()));
	}

	/**
	 * Runs a sample execution of the program, with hard coded calls to the controller.
	 */
	public void sampleExecution(){
		System.out.println("-----------------SALE eligible for discount------------------");
		contr.initiateSale();
		try {
			AddedItemInformation addedItemInformation = contr.addItemToSale(12, 2);
			printAddedItem(addedItemInformation);
			AddedItemInformation addedItemInformation2 = contr.addItemToSale(12, 1);
			printAddedItem(addedItemInformation2);
			AddedItemInformation addedItemInformation3 = contr.addItemToSale(25, 2);
			printAddedItem(addedItemInformation3);
			Amount totalPrice = contr.endSale();
			System.out.println("Total price sale: " + totalPrice +"\n");
			contr.createDiscountRequest(19550530);
			Amount change = contr.pay(new Amount(100));
			System.out.println("Change: " + change);
		} catch(InvalidItemIdException exception) {
			setLogger(consoleLogger);
			logger.log("Could not find item, please try again.");
		} catch(Exception exception) {
			setLogger(fileLogger);
			logger.log(exception.toString());
			setLogger(consoleLogger);
			logger.log("Error occurred. Contact technical support.");
		}
		System.out.println("-----------------SALE not eligible for discount------------------");
		contr.initiateSale();
		try {
			AddedItemInformation addedItemInformation3 = contr.addItemToSale(25, 2);
			printAddedItem(addedItemInformation3);
			Amount totalPrice = contr.endSale();
			System.out.println("Total price sale: " + totalPrice +"\n");
			contr.createDiscountRequest(19980530);
			Amount change = contr.pay(new Amount(100));
			System.out.println("Change: " + change);
		} catch(InvalidItemIdException exception) {
			setLogger(consoleLogger);
			logger.log("Could not find item, please try again.");
		} catch(Exception exception) {
			setLogger(fileLogger);
			logger.log(exception.toString());
			setLogger(consoleLogger);
			logger.log("Error occurred. Contact technical support.");
		}
		System.out.println("--------------SALE with DatabaseException exception-----------------------");
		contr.initiateSale();
		try {
			AddedItemInformation addedItemInformation3 = contr.addItemToSale(50, 2);
			printAddedItem(addedItemInformation3);
			Amount totalPrice = contr.endSale();
			System.out.println("Total price sale: " + totalPrice +"\n");
			Amount change = contr.pay(new Amount(100));
			System.out.println("Change: " + change);
		} catch(InvalidItemIdException exception) {
			setLogger(consoleLogger);
			logger.log("Could not find item, please try again.");
		} catch(Exception exception) {
			setLogger(fileLogger);
			logger.log(exception.toString());
			setLogger(consoleLogger);
			logger.log("Error occurred. Contact technical support.");
		}
	}
}

