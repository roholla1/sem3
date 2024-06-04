package project.se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import project.se.kth.iv1350.model.SaleDTO;

public class ItemRegistry {
     private List<ItemDTO> itemsPresentInRegistry;

    /**
     * Constructs an ItemRegistry and initializes the list of items.
     */
    public ItemRegistry() {
        itemsPresentInRegistry = new ArrayList<>();
        addItemToList();
    }

    /**
     * Searches for an item in the registry based on its unique identifier.
     * 
     * @param itemId The unique identifier of the item to search for.
     * @return The ItemDTO object if found, or null if not found.
     */
    public ItemDTO searchItemById(String itemId) {
        for (ItemDTO item : itemsPresentInRegistry) {
            if (item.getItemId().equals(itemId))
                return new ItemDTO(item.getItemId(), item.getItemName(), item.getItemPrice(), item.getItemVAT(),
                        item.getItemDescription());
        }
        return null;
    }

    private void addItemToList() {
       itemsPresentInRegistry.add(new ItemDTO("abc123", "item1", 28.20, 6, "some description"));
       itemsPresentInRegistry.add(new ItemDTO("abc123", "item1", 28.20, 6, "some description"));
       itemsPresentInRegistry.add(new ItemDTO("def456", "item2", 14.90, 6, "some description"));
    }

    /**
     * Updates the inventory by removing sold items from the registry.
     * 
     * @param itemList The list of items sold in a transaction.
     */

     public void updateInventory(List<SaleDTO> itemList) {
        Iterator<ItemDTO> iterator = itemsPresentInRegistry.iterator();
        while (iterator.hasNext()) {
            ItemDTO item = iterator.next();
            for (SaleDTO saleItem : itemList) {
                ItemDTO saleItemDTO = saleItem.getItemDTO();
                if (item.equals(saleItemDTO)) {
                    iterator.remove();
                    break; 
                }
            }
        }
    }
    

    /**
     * Retrieves the list of items in the registry.
     * 
     * @return The list of ItemDTO objects in the registry.
     */
    public List<ItemDTO> getItemsPresentInRegistry() {
        return itemsPresentInRegistry;
    }
}
