package project.se.kth.iv1350.integration;

import java.util.List;

import project.se.kth.iv1350.model.Sale;
import project.se.kth.iv1350.model.SaleDTO;
/**
 * The ExternalAccountingSystem class handles updates to the external accounting system.
 */
public class ExternalAccountingSystem {
    private List<SaleDTO> itemList;
    
    /**
     * Constructs an ExternalAccountingSystem object.
     */
    public ExternalAccountingSystem(){

    }
    
    /**
     * Updates the accounting system with information from a sale transaction.
     *
     * @param sale The Sale object representing the sale transaction to be updated.
     */
    public void updateAccountingSystem(List<SaleDTO> itemList)
    {
        this.itemList = itemList; 
    }
}
