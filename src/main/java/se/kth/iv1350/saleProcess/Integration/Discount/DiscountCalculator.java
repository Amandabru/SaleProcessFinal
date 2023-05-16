package se.kth.iv1350.saleProcess.Integration.Discount;

import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * An interface for the calculation of the discount
 */
public interface DiscountCalculator {

    /**
     * Calculates the discount of the sale for a specific customer
     * @param sale the <code>sale</code> object representing the sale
     * @param customerId the id of the customer
     * @return the calculated discount
     */
    Amount calculateDiscount(Sale sale, Integer customerId);
}
