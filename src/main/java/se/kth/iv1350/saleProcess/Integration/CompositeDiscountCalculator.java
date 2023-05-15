package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

public class CompositeDiscountCalculator implements DiscountCalculator{
    private List<DiscountCalculator> discountAlgoritmList = new ArrayList<>();
    @Override
    Amount calculateDiscount(Sale sale){
    }

    void addDiscountCalculator(DiscountCalculator calculator) {
        discountAlgoritmList.add(calculator);
    }
}
