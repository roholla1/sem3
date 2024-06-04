package project.se.kth.iv1350.integration;
/**
 * Represents an item in the inventory.
 */
public class ItemDTO {
    private String itemId;
    private String itemName;
    private double itemPrice;
    private double itemVAT;
    private String itemDescription;

    /**
     * Constructs an ItemDTO with the specified attributes.
     *
     * @param itemId          The unique identifier of the item.
     * @param itemName        The name of the item.
     * @param itemPrice       The price of the item.
     * @param itemVAT         The VAT rate applicable to the item.
     * @param itemDescription The description of the item.
     */
    public ItemDTO(String itemId, String itemName, double itemPrice, double itemVAT, String itemDescription) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemVAT = itemVAT;
        this.itemDescription = itemDescription;
    }

    /**
     * Retrieves the unique identifier of the item.
     *
     * @return The item's ID.
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return The item's name.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Retrieves the price of the item.
     *
     * @return The item's price.
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * Retrieves the VAT rate applicable to the item.
     *
     * @return The item's VAT rate.
     */
    public double getItemVAT() {
        return itemVAT;
    }

    /**
     * Retrieves the description of the item.
     *
     * @return The item's description.
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Calculates the total price of the item including VAT.
     *
     * @return The total price of the item with VAT included.
     */
    private double itemsPriceVATIncluded() {
        double vat = this.itemPrice * (getItemVAT() / 100 + 1);
        return Math.ceil(vat * 100) / 100;
    }

    /**
     * Generates a string representation of the item.
     *
     * @return A string representing the item.
     */
    @Override
    public String toString() {
        return "Item ID: " + itemId + "\nItem name: " + itemName
                + "\nItem cost: " + itemsPriceVATIncluded() + " SEK" + "\nVAT: " + itemVAT
                + "\nItem description: " + itemDescription + "\n";
    }

    /**
     * Checks if this item is equal to another object.
     *
     * @param obj The object to compare with this item.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemDTO other = (ItemDTO) obj;
        if (itemId == null) {
            if (other.itemId != null)
                return false;
        } else if (!itemId.equals(other.itemId))
            return false;
        if (itemName == null) {
            if (other.itemName != null)
                return false;
        } else if (!itemName.equals(other.itemName))
            return false;
        if (Double.doubleToLongBits(itemPrice) != Double.doubleToLongBits(other.itemPrice))
            return false;
        if (Double.doubleToLongBits(itemVAT) != Double.doubleToLongBits(other.itemVAT))
            return false;
        if (itemDescription == null) {
            if (other.itemDescription != null)
                return false;
        } else if (!itemDescription.equals(other.itemDescription))
            return false;
        return true;
    }
}
