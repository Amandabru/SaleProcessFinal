package se.kth.iv1350.saleProcess.model;


import se.kth.iv1350.saleProcess.Integration.ItemDTO;
import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * Represents an item and its corresponding quantity
 */
public class LineItem {
	private final ItemDTO item;
	private int quantity;

	/**
	 * Creates a new instance
	 */
	public LineItem(ItemDTO item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * Get the item of the SalesLineIem object
	 * @return the item of the SalesLineItem
	 */
	public ItemDTO getItem(){
		return item;
	}

	/**
	 * Get the price of the SalesLineIem object
	 * @return the price of the SalesLineIem object
	 */
	Amount getPrice(){
		return item.getPrice().multiply(quantity);
	}

	/**
	 * @return the <code>quantity</code> of the item
	 */
	public int getQuantity(){
		return quantity;
	}

	/**
	 * @return the total price including tax for the <code>item</code> of the specified <code>quatity</code>
	 */
	Amount getPriceIncludingTax(){
		return item.getPriceIncludingTax().multiply(quantity);
	}

	/**
	 * Increases the quantity of a line item by the <code>newQuantity</code>
	 * @param newQuantity
	 */
	void increaseQuantity(int newQuantity){
		quantity += newQuantity;
	}

	/**
	 * Decreases the quantity of a line item by the <code>newQuantity</code>
	 * @param newQuantity
	 */
	public void decreaseQuantity(int newQuantity){
		quantity -= newQuantity;
	}
}


