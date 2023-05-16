package se.kth.iv1350.saleProcess.Integration.Discount;

import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

public interface DiscountCalculator {

    Amount calculateDiscount(Sale sale, Integer customerId);
}
