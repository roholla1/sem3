package project.se.kth.iv1350.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.se.kth.iv1350.integration.ExternalAccountingSystem;
import project.se.kth.iv1350.integration.ItemRegistry;
import project.se.kth.iv1350.integration.Printer;
import project.se.kth.iv1350.model.CashPayment;
import project.se.kth.iv1350.model.CashRegister;
import project.se.kth.iv1350.model.Sale;
import project.se.kth.iv1350.model.SaleDTO;
import project.se.kth.iv1350.model.Total;

public class ControllerTest {
    private ItemRegistry itemRegistry;
    private Sale sale;
    private CashRegister cashRegister;
    private CashPayment cashPayment;
    private ExternalAccountingSystem externalAccountingSystem;
    private Printer printer;
    private Controller controller; 
    private Total total; 

    @BeforeEach
    void setUp(){
        controller = new Controller(); 
        itemRegistry = new ItemRegistry(); 
        sale = new Sale(); 
        cashPayment = new CashPayment(200);
        cashRegister = new CashRegister(); 
        externalAccountingSystem = new ExternalAccountingSystem(); 
        printer = new Printer(); 
        total = new Total(); 
        
    }
    @AfterEach
    void tearDown(){
        itemRegistry = null; 
        sale = null; 
        cashRegister = null; 
        cashPayment = null; 
        externalAccountingSystem = null; 
        printer = null; 
    }

    @Test
    void testStartSale() {
        controller.startSale();
        assertNull(controller.registerItem(null),"Sale has not been started");
    }

    @Test
    void testRegisterItem_ValidItem() {
        controller.startSale();
        String itemId = "abc123";
        SaleDTO registeredItem = controller.registerItem(itemId);
        assertNotNull(registeredItem, "Registered item is null.");
    }

    
    @Test
    void testRegisterItem_InvalidItem() {
        controller.startSale();

        String invalidItemId = "invalidItemId";
        SaleDTO registeredItem = controller.registerItem(invalidItemId);
        assertNull(registeredItem, "Registered item is not null for invalid item.");
    }
    
    @Test
    void testEndSale() {
        controller.startSale();
        Total total = controller.endSale();
        assertNotNull(total, "End sale returns null.");
    }

    
    @Test
    void testPay(){
        controller.startSale();
        SaleDTO saleDTO = controller.registerItem("abc123");
        controller.processPayment(100);
        assertEquals(cashPayment.getTotalCost(), cashRegister.getBalance(), "wrong amount has been added to the balance");
        
    }
}
