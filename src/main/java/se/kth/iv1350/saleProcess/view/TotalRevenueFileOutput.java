package se.kth.iv1350.saleProcess.view;

import se.kth.iv1350.saleProcess.model.SaleObserver;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TotalRevenueFileOutput implements SaleObserver {
    private Amount totalRevenue = new Amount();
    private static final String LOG_FILE_NAME = "total-revenue-log.txt";
    private PrintWriter logFile;
    @Override
    public void updateRevenue(Amount runningTotal) {
        addNewSale(runningTotal);
        displaySale();
    }
    private void addNewSale(Amount runningTotal){
        totalRevenue = totalRevenue.plus(runningTotal);
    }

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
