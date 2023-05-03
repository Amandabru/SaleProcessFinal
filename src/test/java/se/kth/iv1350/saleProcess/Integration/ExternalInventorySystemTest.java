package se.kth.iv1350.saleProcess.Integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.saleProcess.model.LineItem;
import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExternalInventorySystemTest {

    private Sale sale;
    private ExternalInventorySystem inventorySystem;

    @BeforeEach
    public void prepareTest(){
        inventorySystem = new ExternalInventorySystem();
        ItemDTO banana = new ItemDTO(12, "Banana", 0.12F, new Amount(2), "Very good banana");
        sale = new Sale();
        sale.addBoughtItem(new LineItem(banana, 5));
    }

    @AfterEach
    public void tearDown() {
        sale = null;
        inventorySystem = null;
    }
    @Test
    void updateInventorySameItem() {
        inventorySystem.updateInventory(sale);
        List<LineItem> items = inventorySystem.getInventoryItems();
        int result = 0;
        int expectedResult= 195; // After having bought 5 bananas, inventory should decrease from 200 to 195.
        for (LineItem inventoryItem: items) {
            if (inventoryItem.getItem().getItemId() == 12) {
                result = inventoryItem.getQuantity();
            }
        }
        assertEquals(expectedResult, result, "Inventory system not updated correctly");
    }

    @Test
    void updateInventoryDifferentItem() {
        inventorySystem.updateInventory(sale);
        List<LineItem> items = inventorySystem.getInventoryItems();
        int result = 0;
        int orangeItemId = 25;
        int expectedResult = 50; //There are 50 items of flour in the inventory at creation
        for (LineItem inventoryItem: items) {
            if (inventoryItem.getItem().getItemId() == orangeItemId) {
                result = inventoryItem.getQuantity();
            }
        }
        assertEquals(expectedResult , result, "Wrong item changes in quantity at inventory update ");
    }
}