package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

public class PremiumCustomerDiscountCalculator implements DiscountCalculator{

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
