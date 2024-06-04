package project.se.kth.iv1350.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.se.kth.iv1350.integration.ItemRegistry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashPaymentTest {
    private ItemRegistry itemRegistry;
    private Sale sale;
    private CashPayment cashPayment;

    @BeforeEach
    void setUp() {
        itemRegistry = new ItemRegistry();
        sale = new Sale();
        cashPayment = new CashPayment(200);

    }

    @AfterEach
    void tearDown() {
        itemRegistry = null;
        sale = null;
        cashPayment = null;
    }

    @Test
    void testCalculateTotalCost() {

        sale.addItem("abc123", itemRegistry);
        sale.addItem("abc123", itemRegistry);

        cashPayment.calculateTotalCost(sale);
        double expectedTotalCost = sale.getTotal().getTotalPrice();
        assertEquals(expectedTotalCost, cashPayment.getTotalCost(),
                "Total cost should match the sale total price");
    }

    @Test
    void testCalculateTotalCostWithZeroItemInSale() {
        sale.addItem(null, itemRegistry);
        sale.addItem(null, itemRegistry);
        cashPayment.calculateTotalCost(sale);
        double expectedTotalCost = 0.0;
        assertEquals(expectedTotalCost, cashPayment.getTotalCost(),
                "Total cost should match the sale total price");
    }

    @Test
    void testGetChange() {
        sale.addItem("abc123", itemRegistry);
        sale.addItem("abc123", itemRegistry);

        double totalPrice = sale.getTotal().getTotalPrice();
        cashPayment.calculateTotalCost(sale);

        double expectedChange = cashPayment.getPiadAmount() - totalPrice;
        assertEquals(expectedChange, cashPayment.getChange(),
                "Change amount should be calculated correctly");
    }

    @Test
    void testGetPaidAmount() {
        double paidAmount = 50;
        CashPayment cashPayment = new CashPayment(paidAmount);
        assertEquals(paidAmount, cashPayment.getPiadAmount(),
                "Paid amount should match the constructor parameter");
    }
}
