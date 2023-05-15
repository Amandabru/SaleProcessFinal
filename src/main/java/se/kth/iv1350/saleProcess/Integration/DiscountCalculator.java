package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

public interface DiscountCalculator {

    Amount calculateDiscount(Sale sale);
}
