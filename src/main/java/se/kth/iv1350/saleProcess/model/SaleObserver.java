package se.kth.iv1350.saleProcess.model;

import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * An interface for notifying observers when a new sale is ended
 */
public interface SaleObserver {

    /**
     * Updates the total revenue that is to be displayed
     * @param totalPrice the total price of the ended sale
     */
    void updateRevenue(Amount totalPrice);
}
