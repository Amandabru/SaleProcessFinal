package se.kth.iv1350.saleProcess.Integration;


import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * ItemDTO stores information about an item object
 */
public class ItemDTO {
	private final int itemId;
	private final String name;
	private final float vatRate;
	private final Amount price;
	private final String itemDescription;
	private final Amount priceIncludingTax;

	/**
	 * Creates a new instance
	 * @param itemId the id of the item
	 * @param name the name of the item
	 * @param vatRate the VAT rate of the item
	 * @param price the unit price of the item
	 * @param itemDescription the description of the item
	 */
	public ItemDTO(int itemId, String name, float vatRate, Amount price, String itemDescription){
		this.itemId = itemId;
		this.name = name;
		this.vatRate = vatRate;
		this.price = price;
		this.itemDescription = itemDescription;
		this.priceIncludingTax = calculatePriceIncludingTax();
	}
	private Amount calculatePriceIncludingTax(){
		return price.multiply(1+vatRate);
	}

	/**
	 * Get the amount of <code>price</code>
	 * @return amount of <code>price</code>
	 */
	public Amount getPrice() {
		return price;
	}

	/**
	 * Get the amount of the price including the VAT rate
	 * @return amount of the price including the VAT rate
	 */
	public Amount getPriceIncludingTax(){
		return priceIncludingTax;
	}

	/**
	 * Get the value of <code>itemId</code>
	 * @return value of <code>itemId</code>
	 */
	public int getItemId(){
		return itemId;
	}

	/**
	 * Get value of <code>itemDescription</code>
	 * @return value of <code>itemDescription</code>
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * Get the name of item
	 * @return the name of item
	 */
	public String getName() {
		return name;
	}

}
