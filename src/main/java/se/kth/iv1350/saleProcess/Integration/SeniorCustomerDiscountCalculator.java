package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.Integration.Discount.DiscountCalculator;
import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the <code>DiscountCalculator</code> interface and that calculates
 * discount for senior customers
 */
public class SeniorCustomerDiscountCalculator implements DiscountCalculator {

    private final List<Integer> seniorCustomers = new ArrayList<Integer>();
    public SeniorCustomerDiscountCalculator(){
        seniorCustomers.add(19550530);
        seniorCustomers.add(19001025);
    }
    /**
     * Senior discount is calculated. The discount means that the customer
     * gets the most expensive item 50% off
     * @param sale the <code>sale</code> object representing the whole sale
     * @return the senior discounted amount for the sale
     */
    @Override
    public Amount calculateDiscount(Sale sale, Integer customerId) {
        if(seniorCustomers.contains(customerId)) {
            List<Float> priceList = sale.getSoldItems().stream()
                    .map(item -> item.getItem().getPrice().getAmount()).toList();
            float mostExpensiveItem = priceList.stream().max(Float::compare).get();
            return new Amount(mostExpensiveItem/2);
        }
        else{
            return new Amount();
        }
    }
}
