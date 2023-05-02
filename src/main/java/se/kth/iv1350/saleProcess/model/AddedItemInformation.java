package se.kth.iv1350.saleProcess.model;


import se.kth.iv1350.saleProcess.Integration.ItemDTO;
import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * Contains information that is to be displayed to the cashier after an item has been entered.
 */
public class AddedItemInformation {
    private final LineItem lineItem;
    private final Amount runningTotalIncludingTax ;

    /**
     * Creates a new instance
     * @param lineItem
     * @param runningTotalIncludingTax
     */
    public AddedItemInformation(LineItem lineItem, Amount runningTotalIncludingTax ) {
        this.lineItem = lineItem;
        this.runningTotalIncludingTax = runningTotalIncludingTax ;
    }

    /**
     * Creates a readable string from the information about the newly added item
     * @return A formatted string representing the content of a newly added item
     */
    @Override
    public String toString() {
        ItemDTO item = lineItem.getItem();
        return String.format("Item: %s \nDescription: %s \nPrice/unit: %s \nQuantity: %s\nRunning Total: %s\n",
                item.getName(), item.getItemDescription(), item.getPriceIncludingTax().toString(), lineItem.getQuantity(),
                runningTotalIncludingTax.toString());
    }
}
