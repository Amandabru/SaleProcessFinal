package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * Class that implements the <code>DiscountCalculator</code> interface and that calculates
 * discount for premium customers.
 */
public class PremiumCustomerDiscountCalculator implements DiscountCalculator{

    /**
     * Premium discount is calculated. The number of bought items decides the
     * percentage of the discount.
     * @param sale the <code>sale</code> object representing the whole sale.
     * @return the premium discount amount for the sale.
     */
    @Override
    public Amount calculateDiscount(Sale sale) {
        Amount discount = new Amount();
        Amount totalPrice = sale.getRunningTotalIncludingTax();
        int numberOfBoughtItems = sale.getSoldItems().size();
        if (numberOfBoughtItems>2){
            discount = totalPrice.multiply(0.2F);
        }
        else if(numberOfBoughtItems>4){
            discount = totalPrice.multiply(0.3F);
        }
        return discount;
    }
}
