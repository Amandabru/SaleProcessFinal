package se.kth.iv1350.saleProcess.view;
import se.kth.iv1350.saleProcess.model.SaleObserver;
import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * Responsible for printing the current revenue of all Sales to <code>System.out</code>
 */
public class TotalRevenueView implements SaleObserver {
    private Amount totalRevenue = new Amount();

    /**
     * Updates the total revenue after ended sale and prints to <code>System.out</code>.
     * @param finalPrice the <code>Amount</code> to add to the revenue.
     */
    @Override
    public void updateRevenue(Amount finalPrice) {
        calculateRevenue(finalPrice);
        printCurrentRevenue();
    }
    private void calculateRevenue(Amount finalPrice){
        totalRevenue = totalRevenue.plus(finalPrice);
    }
    private void printCurrentRevenue() {
        System.out.println("### Total Current Revenue ###");
        System.out.println(totalRevenue);
        System.out.println("##############################");
    }
}
