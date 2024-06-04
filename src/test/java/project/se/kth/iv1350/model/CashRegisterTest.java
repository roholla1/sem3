package project.se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.se.kth.iv1350.integration.ItemRegistry;

public class CashRegisterTest {
    private CashPayment cashPayment;
    private CashRegister cashRegister;
    private Sale sale;
    private ItemRegistry itemRegistry;

    @BeforeEach
    void setUp() {
        sale = new Sale();
        cashPayment = new CashPayment(200);
        cashRegister = new CashRegister();
        itemRegistry = new ItemRegistry();

    }

    @AfterEach
    void tearDown() {
        sale = null;
        cashPayment = null;
        cashRegister = null;
        itemRegistry = null;
    }

    @Test
    void testAddPaymentToRegister() {
        sale.addItem("abc123", itemRegistry);
        cashRegister.addPaymentToRegister(cashPayment);
        double expected = cashPayment.getTotalCost();
        assertEquals(expected, cashRegister.getBalance());
    }
}
