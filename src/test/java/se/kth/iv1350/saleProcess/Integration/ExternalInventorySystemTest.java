package se.kth.iv1350.saleProcess.Integration;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.saleProcess.model.LineItem;
import se.kth.iv1350.saleProcess.model.Sale;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExternalInventorySystemTest {

    @Test
    void getItem() {
        List<LineItem> soldItems = new ArrayList<>();

        for (LineItem lineItem : soldItems){
            for (LineItem inventoryItem: items) {
                if (lineItem.getItem().getItemId() == inventoryItem.getItem().getItemId()) {
                    inventoryItem.decreaseQuantity(lineItem.getQuantity());
                }
            }
        }
    }

    @Test
    void updateInventory() {
    }
}