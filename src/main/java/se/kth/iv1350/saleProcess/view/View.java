package se.kth.iv1350.saleProcess.view;


import se.kth.iv1350.saleProcess.controller.Controller;
import se.kth.iv1350.saleProcess.model.AddedItemInformation;
import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * Class representing the view of the program. It is a placeholder with hard coded calls to operations
 * in the controller.
 */
public class View {
	private final Controller contr;

	/**
	 * Creates a new instance
	 * @param contr the controller
	 */
	public View(Controller contr) {
		this.contr = contr;
	}

	/**
	 * Runs a sample execution of the program, with hard coded calls to the controller.
	 */
	public void sampleExecution(){
		contr.initiateSale();
		AddedItemInformation addedItemInformation = contr.addItemToSale(12, 2);
		System.out.println(addedItemInformation);
		AddedItemInformation addedItemInformation2 = contr.addItemToSale(12, 1);
		System.out.println(addedItemInformation2);
		AddedItemInformation addedItemInformation3 = contr.addItemToSale(25, 2);
		System.out.println(addedItemInformation3);
		Amount totalPrice = contr.endSale();
		System.out.println("Total price sale: " + totalPrice +"\n");
		Amount change = contr.pay(new Amount(100));
		System.out.println("Change: " + change);
	}
}

