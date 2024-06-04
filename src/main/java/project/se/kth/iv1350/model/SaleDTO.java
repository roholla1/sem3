package project.se.kth.iv1350.model;

import project.se.kth.iv1350.integration.ItemDTO;
/**
 * The SaleDTO class represents the data transfer object for sales information.
 */
public class SaleDTO {
    private ItemDTO itemDTO; 
    private double totalVAT; 
    private double totalPriceVATInc;
    private int quantity; 
    
    /**
     * Constructs a SaleDTO object with the specified item information, VAT total, total price including VAT, and quantity.
     *
     * @param itemDTO The ItemDTO object representing the item information.
     * @param totalVAT The total VAT amount.
     * @param totalPriceVATInc The total price including VAT.
     * @param quantity The quantity of items.
     */
    public SaleDTO(ItemDTO itemDTO, double totalVAT, double totalPriceVATInc, int quantity) {
        this.itemDTO = itemDTO;
        this.totalVAT = totalVAT;
        this.totalPriceVATInc = totalPriceVATInc;
        this.quantity = quantity; 
    }
    
    /**
     * Retrieves the ItemDTO object associated with the sale.
     *
     * @return The ItemDTO object representing the item information.
     */
    public ItemDTO getItemDTO() {
        return itemDTO;
    }
    
    /**
     * Retrieves the total VAT amount.
     *
     * @return The total VAT amount.
     */
    public double getTotalVAT() {
        return totalVAT;
    }
    
    /**
     * Retrieves the total price including VAT.
     *
     * @return The total price including VAT.
     */
    public double getTotalPriceVATInc() {
        return totalPriceVATInc;
    }
    
    /**
     * Retrieves the quantity of items.
     *
     * @return The quantity of items.
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Sets the total VAT amount.
     *
     * @param totalVAT The total VAT amount to be set.
     */
    public void setTotalVAT(double totalVAT) {
        this.totalVAT = totalVAT;
    }
    
    /**
     * Sets the total price including VAT.
     *
     * @param totalPriceVATInc The total price including VAT to be set.
     */
    public void setTotalPriceVATInc(double totalPriceVATInc) {
        this.totalPriceVATInc = totalPriceVATInc;
    }
    
    /**
     * Sets the quantity of items.
     *
     * @param quantity The quantity of items to be set.
     */
    public void setQuantity(int quantity){
        this.quantity = quantity; 
    }
   
    /**
     * Returns a string representation of the SaleDTO object.
     *
     * @return A string containing the item information, total cost including VAT, and total VAT.
     */
    @Override
    public String toString() {
        return itemDTO + "\nTotal cost (incl VAT):  " + totalPriceVATInc + " SEK" + "\ntotalVAT: " + totalVAT; 
    }
}
