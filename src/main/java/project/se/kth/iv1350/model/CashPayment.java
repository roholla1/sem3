package project.se.kth.iv1350.model;
/**
 * Represents a cash payment made for a sale transaction.
 */
public class CashPayment {
    private double paidAmount;
    private double totalCost; 
    
    /**
     * Constructs a CashPayment object with the specified paid amount.
     *
     * @param paidAmount The amount paid in cash.
     */
    public CashPayment(double paidAmount ){
        this.paidAmount = paidAmount; 
    }
    
    /**
     * Calculates the total cost of the sale.
     *
     * @param sale The Sale object for which the total cost needs to be calculated.
     */
    public void calculateTotalCost(Sale sale){
        this.totalCost = sale.getTotal().getTotalPrice();
    }
    
    /**
     * Retrieves the change due to the customer.
     *
     * @return The amount of change due to the customer.
     */
    public double getChange(){
        return Double.parseDouble(String.format("%.2f", (this.paidAmount - this.totalCost)));
    }
    
    /**
     * Retrieves the amount paid in cash.
     *
     * @return The amount paid in cash.
     */
    public double getPiadAmount() {
        return paidAmount;
    }
    
    /**
     * Retrieves the total cost of the transaction.
     *
     * @return The total cost of the transaction.
     */
    public double getTotalCost() {
        return totalCost;
    }
}



