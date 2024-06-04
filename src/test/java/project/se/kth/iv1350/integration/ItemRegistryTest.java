package project.se.kth.iv1350.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.se.kth.iv1350.model.SaleDTO;

public class ItemRegistryTest {
    private ItemRegistry itemRegistry;
    private ItemDTO item;

    @BeforeEach
    void setUp() {
        itemRegistry = new ItemRegistry();
    }

    @Test
    void testSearchItemById_ItemExists() {
        item = new ItemDTO("abc123", "item1", 28.20, 6, "some description");
        ItemDTO result = itemRegistry.searchItemById("abc123");
        assertEquals(item, result, "Returned item's ID should match the searched ID.");
    }
    @Test
    public void testSearchItemById_ItemDoesNotExist() {
        String itemId = "nonexistent";
        ItemDTO result = itemRegistry.searchItemById(itemId);
        assertNull(result, "Item with ID " + itemId + " should not exist in the registry.");
    }
    @Test
    public void testUpdateInventory_ItemRemoved() {
        List<SaleDTO> saleItemsToRemove = new ArrayList<>();
        saleItemsToRemove.add(new SaleDTO(new ItemDTO("abc123", 
                            "item1", 28.20, 6, "some description"), 0.0, 0.0, 0));
        itemRegistry.updateInventory(saleItemsToRemove);

        boolean isItemRemoved = itemRegistry.getItemsPresentInRegistry().stream()
                                   .noneMatch(item -> item.getItemId().equals("abc123"));
        assertTrue(isItemRemoved, "Item with ID 'abc123' should be removed from the inventory.");
    }
}
