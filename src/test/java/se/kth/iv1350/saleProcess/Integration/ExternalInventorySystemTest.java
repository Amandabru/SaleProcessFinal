package se.kth.iv1350.saleProcess.Integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.saleProcess.model.LineItem;
import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

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
    void testUpdateInventorySameItem() {
        inventorySystem.updateInventory(sale);
        int bananaItemId = 12;
        int expectedResult= 195; // After having bought 5 bananas, inventory should decrease from 200 to 195.
        int result = inventorySystem.getItemQuantity(bananaItemId);
        assertEquals(expectedResult, result, "Quantity of inventory item not affected by inventory update");
    }

    @Test
    void testUpdateInventoryDifferentItem() {
        inventorySystem.updateInventory(sale);
        int orangeItemId = 25;
        int expectedResult = 50; //There are 50 items of flour in the inventory at creation
        int result = inventorySystem.getItemQuantity(orangeItemId);
        assertEquals(expectedResult , result, "Wrong item changes in quantity at inventory update.");
    }
    
    @Test
    void testGetItemNonExistingItem() {
        int nonExistingId = 10;
        ItemDTO result = inventorySystem.getItem(nonExistingId);
        assertNull(result, "Getting an item that does not exist in inventory does not return null");
    }

    @Test
    void testGetItemExistingItem() {
        int existingId = 12;
        ItemDTO existingItem = new ItemDTO(12, "Banana", 0.12F, new Amount(2), "Very good banana");
        int expectedResult = existingItem.getItemId();
        int result = inventorySystem.getItem(existingId).getItemId();
        assertEquals(expectedResult, result, "Failed to get existing item from inventory");
    }



}