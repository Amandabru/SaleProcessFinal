package se.kth.iv1350.saleProcess.controller;

import se.kth.iv1350.saleProcess.Integration.*;
import se.kth.iv1350.saleProcess.model.AddedItemInformation;
import se.kth.iv1350.saleProcess.model.LineItem;
import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.model.SaleObserver;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

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
	private List<SaleObserver> saleObservers = new ArrayList<>();

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
	 * Start the sale by initiating a <code>Sale</code> object and adding observers.
	 */
	public void initiateSale() {
		this.sale = new Sale();
		sale.addSaleObservers(saleObservers);
	}

	/**
	 * Ends the sale.
	 */
	public Amount endSale() {
		return sale.endSale();
	}

	/**
	 * Adds the observer to the <code>saleObserver</code> list
	 * @param obs the observer to be added to the list
	 */
	public void addSaleObserver(SaleObserver obs) {
		saleObservers.add(obs);
	}

	/**
	 * Adds the item with the specified id to the current sale
	 * @param itemId the id of the added item.
	 * @param quantity the quantity of the added item.
	 * @return information regarding the addedItem.
	 * @throws InvalidItemIdException if the specified item id cannot be found in the inventory.
	 * @throws DataBaseException if the specified item id equals 50, to simulate a database connection problem.
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
		cashRegister.updateBalance(payment.minus(change));
		sale.logSale(accountingSystem, inventorySystem);
		sale.printReceipt(printer);
		return change;
	}

	/**
	 * Creates a discount request
	 * @param customerId the id of the customer that is the personal number
	 */
	public void createDiscountRequest(int customerId){
		Amount discount = discountDatabase.fetchDiscount(customerId, sale);
		sale.setDiscount(discount);
	}

}
