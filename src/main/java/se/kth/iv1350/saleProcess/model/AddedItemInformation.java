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
     * @param lineItem a bought item with its corresponding quantity
     * @param runningTotalIncludingTax the running total including the VAT rate
     */
    public AddedItemInformation(LineItem lineItem, Amount runningTotalIncludingTax ) {
        this.lineItem = lineItem;
        this.runningTotalIncludingTax = runningTotalIncludingTax ;
    }

    /**
     * Get the <code>lineItem</code>
     * @return the line item
     */
    public LineItem getLineItem(){
        return lineItem;
    }

    /**
     * Get the running total including VAT rate
     * @return the running total including VAT rate for the specific <code>lineItem</code>
     */
    public Amount getRunningTotalIncludingTax(){
        return runningTotalIncludingTax;
    }

}
