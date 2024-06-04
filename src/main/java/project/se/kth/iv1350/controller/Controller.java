package project.se.kth.iv1350.controller;

import project.se.kth.iv1350.integration.ExternalAccountingSystem;
import project.se.kth.iv1350.integration.ItemRegistry;
import project.se.kth.iv1350.integration.Printer;
import project.se.kth.iv1350.model.CashPayment;
import project.se.kth.iv1350.model.CashRegister;
import project.se.kth.iv1350.model.Receipt;
import project.se.kth.iv1350.model.Sale;
import project.se.kth.iv1350.model.SaleDTO;
import project.se.kth.iv1350.model.Total;
/**
 * The Controller class manages the flow of operations in the point of sale system.
 */
public class Controller {
    private ItemRegistry itemRegistry;
    private Sale sale;
    private CashRegister cashRegister;
    private CashPayment cashPayment;
    private ExternalAccountingSystem externalAccountingSystem;
    private Printer printer;

    /**
     * Constructs a Controller object with default configurations.
     */
    public Controller() {
        itemRegistry = new ItemRegistry();
        cashRegister = new CashRegister();
        externalAccountingSystem = new ExternalAccountingSystem();
        printer = new Printer();
    }

    /**
     * Starts a new sale transaction.
     */
    public void startSale() {
        sale = new Sale();
    }

    /**
     * Registers an item in the current sale transaction.
     *
     * @param itemId The ID of the item to be registered.
     * @return The SaleDTO object representing the registered item.
     */
    public SaleDTO registerItem(String itemId) {
        return sale.addItem(itemId, itemRegistry);
    }

    /**
     * Ends the current sale transaction and retrieves the total cost.
     *
     * @return The Total object representing the total cost of the sale.
     */
    public Total endSale() {
        return sale.getTotal();
    }

    /**
     * Processes the payment for the current sale transaction.
     *
     * @param paidAmount The amount paid by the customer.
     */
    public void processPayment(double paidAmount) {
        cashPayment = new CashPayment(paidAmount);
        sale.paySale(cashPayment);
        cashRegister.addPaymentToRegister(cashPayment);
        externalAccountingSystem.updateAccountingSystem(sale.getItemList());
        itemRegistry.updateInventory(sale.getItemList());
        Receipt receipt = new Receipt(sale);
        printer.printReceipt(receipt);
    }
}
 