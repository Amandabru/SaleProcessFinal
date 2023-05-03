package se.kth.iv1350.saleProcess.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.saleProcess.Integration.ItemDTO;
import se.kth.iv1350.saleProcess.utils.Amount;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {

    @BeforeEach
    public void prepareTest(){
        ItemDTO firstItem = new ItemDTO(12, "Peanuts", 0.25F, new Amount(20), "Very tasty");
        // ItemDTO secondItem = new ItemDTO(4, "Orange", 0.25F, new Amount(10), "Very good");
        LineItem firstLineItem = new LineItem(firstItem, 6);
        LineItem secondLineItem = new LineItem(firstItem, 3);
        // LineItem secondLineItem = new LineItem(secondItem, 3);
    }
    @Test
    void increaseQuantityTest() {

    }

    @Test
    void decreaseQuantityTest() {

    }
}