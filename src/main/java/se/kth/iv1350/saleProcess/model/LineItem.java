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
	 * Get the item of the <code>LineItem</code> object
	 * @return the <code>itemDTO</code> of the <code>LineItem</code>
	 */
	public ItemDTO getItem(){
		return item;
	}

	/**
	 * Get the price of the <code>LineItem</code> object
	 * @return the price of the <code>LineItem</code> object
	 */
	Amount getPrice(){
		return item.getPrice().multiply(quantity);
	}

	/**
	 * Get the quantity of the <code>LineItem</code>
	 * @return the <code>quantity</code> of the item
	 */
	public int getQuantity(){
		return quantity;
	}

	/**
	 * Get the price including VAT rate
	 * @return the total price including tax for the specified <code>quantity</code> of <code>item</code>
	 */
	Amount getPriceIncludingTax(){
		return item.getPriceIncludingTax().multiply(quantity);
	}

	/**
	 * Increases the quantity of a line item by the <code>newQuantity</code>
	 * @param newQuantity the quantity that is to be added
	 */
	void increaseQuantity(int newQuantity){
		quantity += newQuantity;
	}

	/**
	 * Decreases the quantity of a line item by the <code>newQuantity</code>
	 * @param newQuantity the quantity that is to be subtracted
	 */
	public void decreaseQuantity(int newQuantity){
		quantity -= newQuantity;
	}
}


