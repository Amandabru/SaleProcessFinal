package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.model.LineItem;
import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeniorCustomerDiscountCalculator implements DiscountCalculator{

    @Override
    public Amount calculateDiscount(Sale sale) {
        List<Amount> priceList = sale.getSoldItems().stream()
                .map(item -> item.getItem().getPrice().)
        .toList();
        priceList.stream().max()
        return Amount();
    }
}
