package project.se.kth.iv1350.model;
/**
 * The CashRegister class manages the balance of cash payments.
 */
public class CashRegister {
    private double balance; 
    
    /**
     * Constructs a CashRegister object with initial balance set to zero.
     */
    public CashRegister(){
    }
    
    /**
     * Adds the total cost of a cash payment to the register balance.
     *
     * @param cashPayment The CashPayment object representing the payment to be added to the register.
     */
    public void addPaymentToRegister(CashPayment cashPayment){
        this.balance += cashPayment.getTotalCost();
    }
    
    /**
     * Retrieves the current balance of the cash register.
     *
     * @return The current balance of the cash register.
     */
    public double getBalance() {
        return balance;
    }
}
