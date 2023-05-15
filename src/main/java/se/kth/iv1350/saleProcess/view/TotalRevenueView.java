package se.kth.iv1350.saleProcess.view;
import se.kth.iv1350.saleProcess.model.SaleObserver;
import se.kth.iv1350.saleProcess.utils.Amount;
public class TotalRevenueView implements SaleObserver {
    private Amount totalRevenue = new Amount();
    @Override
    public void newSale(Amount runningTotal) {
        addNewSale(runningTotal);
        printCurrentRevenue();
    }
    private void addNewSale(Amount runningTotal){
        totalRevenue = totalRevenue.plus(runningTotal);
    }
    private void printCurrentRevenue() {
        System.out.println("### Total Current Revenue ###");
        System.out.println(totalRevenue);
        System.out.println("##############################");
    }
}
