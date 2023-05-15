package se.kth.iv1350.saleProcess.model;


import se.kth.iv1350.saleProcess.Integration.ExternalAccountingSystem;
import se.kth.iv1350.saleProcess.Integration.ExternalInventorySystem;
import se.kth.iv1350.saleProcess.Integration.ItemDTO;
import se.kth.iv1350.saleProcess.Integration.Printer;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that stores information about the ongoing sale
 */
public class Sale {
	private Amount runningTotal;
	private Amount runningTotalIncludingTax;
	private final List<LineItem> soldItems = new ArrayList<>();
	private Amount change;

	private List<SaleObserver> saleObservers = new ArrayList<>();

	/**
	 * Creates a new instance
	 */
	public Sale() {
		this.runningTotal = new Amount();
		this.runningTotalIncludingTax = new Amount();
	}

	/**
	 * Adds a <code>LineItem</code> object to the current sale.
	 *
	 * @param lineItem representing an item and its corresponding quantity
	 * @return an <code>AddedItemInformation</code> object that contains information
	 * that is to be displayed to the cashier.
	 */
	public AddedItemInformation addBoughtItem(LineItem lineItem) {
		soldItems.add(lineItem);
		updateRunningTotal(lineItem.getPrice());
		updateRunningTotalIncludingTax(lineItem.getPriceIncludingTax());
		return new AddedItemInformation(lineItem, runningTotalIncludingTax);
	}

	/**
	 * Ends the sale
	 *
	 * @return the running total including the VAT rate
	 */
	public Amount endSale() {
		return runningTotalIncludingTax;
	}

	/**
	 * Calculates the change from the paid amount by the customer.
	 *
	 * @param payment the amount paid by the customer
	 * @return the <code>change</code> that the customer should be given
	 */
	public Amount calculateChange(Amount payment) {
		change = payment.minus(runningTotalIncludingTax);
		return change;
	}

	/**
	 * Prints the receipts
	 *
	 * @param printer the printer
	 */
	public void printReceipt(Printer printer) {
		Receipt receipt = new Receipt(this);
		printer.printReceipt(receipt);
	}

	/**
	 * Logs the information about the sale
	 *
	 * @param accountSys   the external accounting system
	 * @param inventorySys the external inventory system
	 */
	public void logSale(ExternalAccountingSystem accountSys, ExternalInventorySystem inventorySys) {
		SalesLog salesLog = new SalesLog(accountSys, inventorySys);
		salesLog.updateSystems(this);
		notifyObservers();
	}

	/**
	 * Increases the quantity of a <code>LineItem</code> when the item is registered more than once
	 *
	 * @param itemId   the id of the item that is registered
	 * @param quantity the quantity that is to be added to the <code>LineItem</code>
	 * @return an <code>AddedItemInformation</code> object that contains information
	 * that is to be displayed to the cashier.
	 */
	public AddedItemInformation increaseQuantity(int itemId, int quantity) {
		LineItem lineItem = findLineItemById(itemId);
		ItemDTO item = lineItem.getItem();
		Amount priceIncludingTax = item.getPriceIncludingTax().multiply(quantity);
		Amount priceExcludingTax = item.getPrice().multiply(quantity);
		lineItem.increaseQuantity(quantity);
		updateRunningTotal(priceExcludingTax);
		updateRunningTotalIncludingTax(priceIncludingTax);
		return new AddedItemInformation(lineItem, runningTotalIncludingTax);
	}

	/**
	 * Checks if an item is already recorded in the current sale
	 *
	 * @param itemId the id of the item that is to be checked
	 * @return the <code>LineItem</code> if the item was already recorded. If not, <code>null</code>
	 * is returned.
	 */
	public boolean isRecorded(int itemId) {
		LineItem lineItem = findLineItemById(itemId);
		return lineItem != null;
	}

	/**
	 * Get the list of sold items
	 *
	 * @return the list of <code>soldItems</code>
	 */
	public List<LineItem> getSoldItems() {
		return soldItems;
	}

	/**
	 * Get the running total including the VAT rate
	 *
	 * @return the amount of the running total including the VAT rate
	 */
	Amount getRunningTotalIncludingTax() {
		return runningTotalIncludingTax;
	}

	/**
	 * get the change from the customer's paid amount
	 *
	 * @return the <code>change</code> that the customer should be given
	 */
	Amount getChange() {
		return change;
	}

	/**
	 * Get the total VAT of the sale
	 *
	 * @return the total VAT of the sale
	 */
	Amount getTotalVat() {
		return runningTotalIncludingTax.minus(runningTotal);
	}

	private LineItem findLineItemById(int itemId) {
		for (LineItem lineItem : soldItems) {
			if (lineItem.getItem().getItemId() == itemId) {
				return lineItem;
			}
		}
		return null;
	}

	private void updateRunningTotal(Amount amountToAdd) {
		runningTotal = runningTotal.plus(amountToAdd);
	}

	private void updateRunningTotalIncludingTax(Amount amountToAdd) {
		runningTotalIncludingTax = runningTotalIncludingTax.plus(amountToAdd);
	}


	/**
	 * Adds all the observers in the <code>observers</code> list to the <code>SaleObservers</code> list
	 * @param observers the list of observers
	 */
	public void addSaleObservers(List<SaleObserver> observers) {
		saleObservers.addAll(observers);
	}

	private void notifyObservers() {
		for (SaleObserver obs : saleObservers) {
			obs.updateRevenue(runningTotalIncludingTax);
		}
	}
}