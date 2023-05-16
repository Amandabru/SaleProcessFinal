package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.Integration.Discount.DiscountCalculator;
import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the <code>DiscountCalculator</code> interface and that calculates
 * discount for premium customers.
 */
public class PremiumCustomerDiscountCalculator implements DiscountCalculator {

    private final List<Integer> premiumCustomers = new ArrayList<Integer>();

    /**
     * Creates a new instance of <code>PremiumCustomerDiscountCalculator</code>
     */
    public PremiumCustomerDiscountCalculator(){
        premiumCustomers.add(19980704);
        premiumCustomers.add(19550530);
    }

    /**
     * Premium discount is calculated. The number of bought items decides the
     * percentage of the discount.
     * @param sale the <code>sale</code> object representing the whole sale.
     * @param customerId the id of the customer being a personal number
     * @return the premium discount for the sale.
     */
    @Override
    public Amount calculateDiscount(Sale sale, Integer customerId) {
        Amount discount = new Amount();
        if(premiumCustomers.contains(customerId)) {
            Amount totalPrice = sale.getRunningTotalIncludingTax();
            if (sale.getTotalNumberOfItems() > 2) {
                discount = totalPrice.multiply(0.2F);
            } else if (sale.getTotalNumberOfItems() > 4) {
                discount = totalPrice.multiply(0.3F);
            }
        }
        return discount;
    }
}
