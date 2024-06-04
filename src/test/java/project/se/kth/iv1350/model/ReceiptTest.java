package project.se.kth.iv1350.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.se.kth.iv1350.integration.ItemRegistry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    ItemRegistry itemRegistry;
    private Sale sale;
    private Receipt receipt;
    private CashPayment cashPayment;

    @BeforeEach
    void setUp() {
        sale = new Sale();
        receipt = new Receipt(sale);
        cashPayment = new CashPayment(200);
        sale.paySale(cashPayment);
        itemRegistry = new ItemRegistry();
    }

    @AfterEach
    void tearsDown() {
        sale = null;
        receipt = null;
        cashPayment = null;
    }

    @Test
    void testToStringMethodOutput() {
        String expected = "\n------------------Begin receipt------------------\n" +
                "Time of sale: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\n\n"
                +
                sale.toString() +
                "\n-----------------------END---------------\n" +
                "The change to give customer: " + sale.getCashPayment().getChange() + " SEK";
        assertEquals(expected, receipt.toString(), "toString method does not return expected output");
    }

    @Test
    void testReceiptConstruction() {
        Sale sale = new Sale();
        Receipt receipt = new Receipt(sale);
        assertNotNull(receipt, "Receipt construction failed");
    }

    @Test
    void testTimeOfSale() {
        String timeOfSale = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertTrue(receipt.toString().contains("Time of sale: " + timeOfSale), "Time of sale is incorrect");
    }

    @Test
    void testChangeAmount() {
        assertTrue(
                receipt.toString()
                        .contains("The change to give customer: " + sale.getCashPayment().getChange() + " SEK"),
                "Change amount is incorrect");
    }

    @Test
    void testEdgeCases() {
        Sale saleWithMultipleItems = new Sale();
        saleWithMultipleItems.addItem("abc123", itemRegistry);
        saleWithMultipleItems.addItem("def456", itemRegistry);

        Sale saleWithZeroChange = new Sale();
        saleWithZeroChange.paySale(new CashPayment(0));

        Sale missingSaleInformation = null;

        Receipt receiptWithMultipleItems = new Receipt(saleWithMultipleItems);
        Receipt receiptWithZeroChange = new Receipt(saleWithZeroChange);
        Receipt receiptWithMissingSaleInfo = new Receipt(missingSaleInformation);

        assertNotNull(receiptWithMultipleItems, "Receipt should not be null for sale with multiple items");
        assertTrue(
                receiptWithZeroChange.toString().contains(
                        "The change to give customer: " + saleWithZeroChange.getCashPayment().getChange() + " SEK"),
                "Change amount should be zero in receipt for sale with zero change");

        assertNotNull(receiptWithMissingSaleInfo, "Receipt should not be null for missing sale information");
    }

}
