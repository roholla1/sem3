package project.se.kth.iv1350.model;

import project.se.kth.iv1350.integration.ItemDTO;
/**
 * The Total class represents the total cost and VAT calculation for a sale.
 */
public class Total {
    private double totalPrice;
    private double totalVAT; 
    private int quantity; 
    
    /**
     * Constructs a Total object with default values.
     */
    public Total(){

    }
    
    /**
     * Calculates the running total price including VAT for the given item and quantity.
     *
     * @param itemDTO The ItemDTO object representing the item information.
     * @param quantity The quantity of items.
     * @return The running total price including VAT.
     */
    public double runningTotal(ItemDTO itemDTO, int quantity){
        double total = quantity * itemDTO.getItemPrice() * (itemDTO.getItemVAT() / 100 + 1);
        this.totalPrice += Double.parseDouble(String.format("%.2f", total)); 
        return this.totalPrice; 
    }
    
    /**
     * Calculates the running total VAT for the given item and quantity.
     *
     * @param itemDTO The ItemDTO object representing the item information.
     * @param quantity The quantity of items.
     * @return The running total VAT.
     */
    public double runningTotalVAT(ItemDTO itemDTO, int quantity) {
        this.totalVAT += (quantity * itemDTO.getItemPrice() * (itemDTO.getItemVAT() / 100));
        return Double.parseDouble(String.format("%.2f", totalVAT));
       
    }
    
    /**
     * Updates the quantity of items.
     *
     * @param quantity The quantity of items to be added.
     * @return The updated quantity.
     */
    public int updateQuantity(int quantity){
        this.quantity += quantity;  
        return this.quantity; 
    } 
    
    /**
     * Retrieves the total price including VAT.
     *
     * @return The total price including VAT.
     */
    public double getTotalPrice() {
        double roundedTotalPrice = Math.ceil(totalPrice * 100) / 100; 
        return roundedTotalPrice;
    }
    
    /**
     * Retrieves the total VAT.
     *
     * @return The total VAT.
     */
    public double getTotalVAT() {
        return Double.parseDouble(String.format("%.2f", totalVAT));
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
     * Sets the quantity of items.
     *
     * @param quantity The quantity of items to be set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Returns a string representation of the Total object.
     *
     * @return A string containing the total cost including VAT.
     */
    @Override
    public String toString() {
        return "Total cost (incl VAT): " + totalPrice;
    }
}
