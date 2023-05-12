package se.kth.iv1350.saleProcess.controller;

import se.kth.iv1350.saleProcess.Integration.*;
import se.kth.iv1350.saleProcess.model.AddedItemInformation;
import se.kth.iv1350.saleProcess.model.LineItem;
import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * This is the controller of the application.
 * It handles calls to the model.
 */
public class Controller {
	private final CashRegister cashRegister;
	private final Printer printer;
	private final ExternalInventorySystem inventorySystem;
	private final ExternalAccountingSystem accountingSystem;
	private final DiscountDatabase discountDatabase;
	private Sale sale;

	/**
	 * Creates a new instance
	 * @param creator the creator of the external systems
	 * @param printer the printer
	 */
	public Controller(SystemCreator creator, Printer printer) {
		this.inventorySystem= creator.getInventorySystem();
		this.accountingSystem = creator.getAccountingSystem();
		this.discountDatabase = creator.getDiscountDatabase();
		this.cashRegister = creator.getCashRegister();
		this.printer = printer;
	}

	/**
	 * Start the sale by initiating a <code>Sale</code> object.
	 */
	public void initiateSale() {
		this.sale = new Sale();
	}

	/**
	 * Ends the sale.
	 */
	public Amount endSale() {
		return sale.endSale();
	}

	/**
	 * Adds the item with the specified id to the current sale
	 * @param itemId the id of the added item.
	 * @param quantity the quantity of the added item.
	 * @return information regarding the addedItem.
	 */
	public AddedItemInformation addItemToSale(int itemId, int quantity) throws InvalidItemIdException, DataBaseException {
		AddedItemInformation addedItemInformation;
		if (sale.isRecorded(itemId)){
			addedItemInformation = sale.increaseQuantity(itemId, quantity);
		}
		else {
			ItemDTO item = inventorySystem.getItem(itemId);
			LineItem lineItem = new LineItem(item, quantity);
			addedItemInformation = sale.addBoughtItem(lineItem);
		}
		return addedItemInformation;
	}

	/**
	 * Adds the payment that the customer have given
	 * @param payment an <code>Amount</code> object representing the amount the customer have paid
	 * @return an <code>Amount</code> object representing the change that the customer should be given.
	 */
	public Amount pay(Amount payment) {
		Amount change = sale.calculateChange(payment);
		cashRegister.updateBalance(payment);
		sale.logSale(accountingSystem, inventorySystem);
		sale.printReceipt(printer);
		return change;
	}

	public Amount createDiscountRequest(int customerId) {
		return null;
	}

}
