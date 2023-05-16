package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite that implements <code>discountCalculator</code> and handles the discount calculation.
 */
public class CompositeDiscountCalculator implements DiscountCalculator{
    private List<DiscountCalculator> discountAlgorithmList = new ArrayList<>();

    /**
     * Calculates the discount by applying the discount algorithm that results in the largest discount.
     * @param sale the current sale that is to be discounted.
     * @param customerId the customer id of the customer.
     * @return the largest possible discount for the sale.
     */
    @Override
    public Amount calculateDiscount(Sale sale, Integer customerId){
        Amount bestDiscount = new Amount();
        for (DiscountCalculator discountCal : discountAlgorithmList){
            Amount currentDiscount = discountCal.calculateDiscount(sale, customerId);
            if(currentDiscount.isLarger(bestDiscount)){
                bestDiscount = currentDiscount;
            }
        }
        return bestDiscount;
    }

    void addDiscountCalculator(DiscountCalculator calculator) {
        discountAlgorithmList.add(calculator);
    }
}
