package se.kth.iv1350.saleProcess.view;

import se.kth.iv1350.saleProcess.model.SaleObserver;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Updates the total revenue after ended sale and prints to file.
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private Amount totalRevenue = new Amount();
    private static final String LOG_FILE_NAME = "total-revenue-log.txt";
    private PrintWriter logFile;

    /**
     * Updates the total revenue after ended sale and prints to file.
     * @param finalPrice the <code>Amount</code> to add to the revenue.
     */
    @Override
    public void updateRevenue(Amount finalPrice) {
        calculateRevenue(finalPrice);
        displaySale();
    }
    private void calculateRevenue(Amount finalPrice){
        totalRevenue = totalRevenue.plus(finalPrice);
    }

    /**
     * Writes the total revenue of the sale to a log.
     */
    private void displaySale(){
        try {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME, true), true);
            logFile.println("Total revenue: " + totalRevenue.toString());
        } catch (IOException ex) {
            System.out.println("Could not create logger.");
            ex.printStackTrace();
        }
    }
}
