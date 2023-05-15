package se.kth.iv1350.saleProcess.view;


import se.kth.iv1350.saleProcess.Integration.DataBaseException;
import se.kth.iv1350.saleProcess.Integration.InvalidItemIdException;
import se.kth.iv1350.saleProcess.controller.Controller;
import se.kth.iv1350.saleProcess.model.AddedItemInformation;
import se.kth.iv1350.saleProcess.model.ConsoleLogger;
import se.kth.iv1350.saleProcess.model.FileLogger;
import se.kth.iv1350.saleProcess.model.Logger;
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
	 * Runs a sample execution of the program, with hard coded calls to the controller.
	 */
	public void sampleExecution(){
		contr.initiateSale();
		try {
			AddedItemInformation addedItemInformation = contr.addItemToSale(12, 2);
			System.out.println(addedItemInformation);
			AddedItemInformation addedItemInformation2 = contr.addItemToSale(12, 1);
			System.out.println(addedItemInformation2);
			AddedItemInformation addedItemInformation3 = contr.addItemToSale(25, 2);
			System.out.println(addedItemInformation3);
			Amount totalPrice = contr.endSale();
			System.out.println("Total price sale: " + totalPrice +"\n");
			contr.createDiscountRequest(19550530);
			Amount change = contr.pay(new Amount(100));
			System.out.println("Change: " + change);
		} catch(InvalidItemIdException exception) {
			setLogger(consoleLogger);
			logger.log("Could not find item, please try again.");
		} catch(DataBaseException exception) {
			setLogger(fileLogger);
			logger.log(exception.toString());
			setLogger(consoleLogger);
			logger.log("Error occurred when trying to get item information. Contact technical support.");
		}
		System.out.println("-------------------------------------------------");
		contr.initiateSale();
		try {
			AddedItemInformation addedItemInformation = contr.addItemToSale(12, 2);
			System.out.println(addedItemInformation);
			AddedItemInformation addedItemInformation2 = contr.addItemToSale(12, 1);
			System.out.println(addedItemInformation2);
			AddedItemInformation addedItemInformation3 = contr.addItemToSale(25, 2);
			System.out.println(addedItemInformation3);
			Amount totalPrice = contr.endSale();
			System.out.println("Total price sale: " + totalPrice +"\n");
			contr.createDiscountRequest(19980530);
			Amount change = contr.pay(new Amount(100));
			System.out.println("Change: " + change);
		} catch(InvalidItemIdException exception) {
			setLogger(consoleLogger);
			logger.log("Could not find item, please try again.");
		} catch(DataBaseException exception) {
			setLogger(fileLogger);
			logger.log(exception.toString());
			setLogger(consoleLogger);
			logger.log("Error occurred when trying to get item information. Contact technical support.");
		}
	}
}

