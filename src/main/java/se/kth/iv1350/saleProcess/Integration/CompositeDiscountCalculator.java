package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

public class CompositeDiscountCalculator implements DiscountCalculator{
    private List<DiscountCalculator> discountAlgorithmList = new ArrayList<>();
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
