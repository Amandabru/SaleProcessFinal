package se.kth.iv1350.saleProcess.Integration;


import se.kth.iv1350.saleProcess.model.LineItem;
import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the external inventory system which stores information about items
 * that exists in the retail store.
 * It is a placeholder for the real inventory system which will be a database.
 */
public class ExternalInventorySystem {
	private final List<LineItem> items = new ArrayList<>();

	/**
	 * Creates a new instance and adds <code>ItemDTOs</code> to the <code>items</code> list.
	 */
	ExternalInventorySystem() {
		addItems();
	}

	/**
	 * Adds an <code>ItemDTO</code> to the <code>ArrayList</code> which is representing the external inventory system.
	 * The added item is hard coded and an example of an item that might exist in the retail store.
	 */
	private void addItems(){
		ItemDTO banana = new ItemDTO(12, "Banana", 0.12F, new Amount(2), "Very good banana");
		ItemDTO flour = new ItemDTO(25, "Flour (1kg)", 0.12F, new Amount(15), "Very good flour");
		items.add(new LineItem(banana, 200));
		items.add(new LineItem(flour, 50));
	}

	/**
	 * Method that returns the <code>ItemDTO</code> from a given item id.
	 * @param itemId The item id that is used for finding a specific item.
	 * @return the item if the matching item id is found. Otherwise <code>null</code> is returned.
	 */
	public ItemDTO getItem(int itemId) {
		for (LineItem lineItem : items) {
			ItemDTO item = lineItem.getItem() ;
			if (item.getItemId() == itemId) {
				return item;
			}
		}
		return null;
	}

	/**
	 * Updates the inventory based on the made sale.
	 * The quantity in the inventory is changed depending on how many quantities have been sold of each item.
	 * @param sale the <code>Sale</code> object representing the current sale.
	 */
	public void updateInventory(Sale sale) {
		List<LineItem> soldItems = sale.getSoldItems();
		for (LineItem lineItem : soldItems){
				for (LineItem inventoryItem: items) {
					if (lineItem.getItem().getItemId() == inventoryItem.getItem().getItemId()) {
						inventoryItem.decreaseQuantity(lineItem.getQuantity());
				}
			}
		}
	}

}
