package project.se.kth.iv1350.integration;

import project.se.kth.iv1350.model.Receipt;
/**
 * Represents a printer used to print receipts.
 */
public class Printer {
    
    /**
     * Prints the provided receipt.
     *
     * @param receipt The receipt to be printed.
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt);
    }
}
