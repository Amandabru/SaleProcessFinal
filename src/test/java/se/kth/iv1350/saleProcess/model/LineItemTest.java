package se.kth.iv1350.saleProcess.model;

import org.junit.jupiter.api.*;
import se.kth.iv1350.saleProcess.Integration.ItemDTO;
import se.kth.iv1350.saleProcess.utils.Amount;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {
    private LineItem lineItem;
    @BeforeEach
    public void prepareTest(){
        ItemDTO firstItem = new ItemDTO(12, "Peanuts", 0.25F, new Amount(20), "Very tasty");
        lineItem = new LineItem(firstItem, 6);
    }
    @AfterEach
    public void tearDown() {
        lineItem = null;
  }
    @Test
    void increaseQuantityEqualTest() {
        lineItem.increaseQuantity(7);
        assertEquals(13, lineItem.getQuantity(), "The quantities are not equal");
    }

    @Test
    void increaseQuantityNotNullTest() {
        lineItem.increaseQuantity(30);
        assertNotNull(lineItem.getQuantity(), "The quantity is null");
    }

    @Test
    void decreaseQuantityEqualTest() {
        lineItem.decreaseQuantity(3);
        assertEquals(3, lineItem.getQuantity(), "The quantities are not equal");
    }

    @Test
    void decreaseQuantityNotNullTest() {
        lineItem.decreaseQuantity(3);
        assertNotNull(lineItem.getQuantity(), "The quantity is null");
    }

}