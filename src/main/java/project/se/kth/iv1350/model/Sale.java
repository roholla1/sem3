package project.se.kth.iv1350.model;

import java.util.ArrayList;
import java.util.List;

import project.se.kth.iv1350.integration.ItemDTO;
import project.se.kth.iv1350.integration.ItemRegistry;

/**
 * Represents a sale transaction.
 */
public class Sale {
    private List<SaleDTO> itemList;
    private Total total;
    private CashPayment cashPayment;

    /**
     * Constructs a new Sale object.
     */
    public Sale() {
        this.itemList = new ArrayList<>();
        this.total = new Total();
    }

    /**
     * Retrieves the list of items in the sale.
     *
     * @return The list of items in the sale.
     */
    public List<SaleDTO> getItemList() {
        return itemList;
    }

    /**
     * Adds an item to the sale.
     *
     * @param itemId       The ID of the item to be added.
     * @param itemRegistry The registry containing items.
     * @return The added SaleDTO object.
     */
    public SaleDTO addItem(String itemId, ItemRegistry itemRegistry) {
        int quantity = 1;
        for (SaleDTO item : itemList) {
            if (item.getItemDTO().getItemId().equals(itemId)) {
                double totalPric = total.runningTotal(item.getItemDTO(), quantity);
                double totalVAT = total.runningTotalVAT(item.getItemDTO(), quantity);
                int itemQuantity = total.updateQuantity(quantity);
                addTotalToItemList(item, totalPric);
                addTotalVATToItemList(item, totalVAT);
                updateItemQuantity(item, itemQuantity);
                return item;
            }
        }

        ItemDTO foundItem = itemRegistry.searchItemById(itemId);
        if (foundItem != null) {
            double totalPric = total.runningTotal(foundItem, quantity);
            double totalVAT = total.runningTotalVAT(foundItem, quantity);
            total.setQuantity(quantity);
            SaleDTO newSaleItem = new SaleDTO(foundItem, totalVAT, totalPric, quantity);
            itemList.add(newSaleItem);
            return newSaleItem;
        }
        return null;
    }

    /**
     * Retrieves the total amount of the sale.
     *
     * @return The total amount of the sale.
     */
    public Total getTotal() {
        return total;
    }

    /**
     * Processes the payment for the sale.
     *
     * @param cashPayment The CashPayment object representing the payment.
     */
    public void paySale(CashPayment cashPayment) {
        cashPayment.calculateTotalCost(this);
        this.cashPayment = cashPayment;
    }

    /**
     * Retrieves the CashPayment object associated with the sale.
     *
     * @return The CashPayment object associated with the sale.
     */
    public CashPayment getCashPayment() {
        return cashPayment;
    }

    /**
     * Generates a string representation of the sale.
     *
     * @return A string representation of the sale.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (SaleDTO item : itemList) {
            String itemName = item.getItemDTO().getItemName();
            int itemQuantity = item.getQuantity();
            double itemPrice = item.getItemDTO().getItemPrice() * (1 + item.getItemDTO().getItemVAT() / 100);
            double totalPrice = itemQuantity * itemPrice;

            builder.append(itemName)
                    .append(String.format("%1$30s", itemQuantity + " x "))
                    .append(String.format("%.2f", itemPrice))
                    .append(String.format("%1$30s", String.format("%.2f", totalPrice)))
                    .append(" SEK")
                    .append("\n");
        }
        builder.append("\n")
                .append("Total:")
                .append(String.format("%1$64s", String.format("%.2f", getTotal().getTotalPrice())))
                .append(" SEK")
                .append("\n")
                .append("VAT: ")
                .append(String.format("%.2f", total.getTotalVAT()))
                .append("\n\n")
                .append("Cash:")
                .append(String.format("%1$66s", String.format("%.2f", this.cashPayment.getPiadAmount())))
                .append(" SEK")
                .append("\n")
                .append("Change:")
                .append(String.format("%1$64s", String.format("%.2f", this.cashPayment.getChange())))
                .append(" SEK");

        return builder.toString();

    }

    private void addTotalToItemList(SaleDTO saleDTO, double totalPriceVATInc) {
        saleDTO.setTotalPriceVATInc(totalPriceVATInc);
    }

    private void addTotalVATToItemList(SaleDTO saleDTO, double totalVAT) {
        saleDTO.setTotalVAT(totalVAT);
    }

    private void updateItemQuantity(SaleDTO saleDTO, int quantity) {
        saleDTO.setQuantity(quantity);
    }
}
