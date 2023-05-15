package se.kth.iv1350.saleProcess.model;

import se.kth.iv1350.saleProcess.utils.Amount;

public interface SaleObserver {
    void newSale(Amount totalPrice);
}
