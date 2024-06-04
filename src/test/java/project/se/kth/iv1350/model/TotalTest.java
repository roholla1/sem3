package project.se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.se.kth.iv1350.integration.ItemDTO;

public class TotalTest {
    private ItemDTO itemDTO;
    private Total total;

    @BeforeEach
    void setUp() {
        total = new Total();
    }

    @AfterEach
    void tearDown() {
        itemDTO = null;
    }

    @Test
    void testRunningTotalForOneItem() {
        itemDTO = new ItemDTO("abc123", "item1", 28.20, 6, "some description");
        double totalPrice = 1 * itemDTO.getItemPrice() * (itemDTO.getItemVAT() / 100 + 1);
        double expected = Double.parseDouble(String.format("%.2f", totalPrice));
        double result = total.runningTotal(itemDTO, 1);
        assertEquals(expected, result,
                "The test failed because the calculated total price for one item does not match the expected value.");

    }

    @Test
    void testRuningTotalForTwoOrMoreItem() {
        itemDTO = new ItemDTO("abc123", "item1", 28.20, 6, "some description");
        double totalPrice = 2 * itemDTO.getItemPrice() * (itemDTO.getItemVAT() / 100 + 1);
        double expected = Double.parseDouble(String.format("%.2f", totalPrice));
        double result = total.runningTotal(itemDTO, 2);
        assertEquals(expected, result,
                "The test failed because the calculated total price for two item does not match the expected value.");

    }

    @Test
    void testRunningTotalWithZeroPrice() {
        itemDTO = new ItemDTO("abc123", "item1", 0, 6, "some description");
        double expected = 0.0;
        double result = total.runningTotal(itemDTO, 1);
        assertEquals(expected, result,
                "The test failed because the calculated total price for an item with a zero price does not match the expected value.");
    }

    @Test
    void testRunningTotalVATForOneItem() {
        itemDTO = new ItemDTO("abc123", "item1", 28.20, 6, "some description");
        double totalVAT = (1 * itemDTO.getItemPrice() * (itemDTO.getItemVAT() / 100));
        double expected = Double.parseDouble(String.format("%.2f", totalVAT));
        double result = total.runningTotalVAT(itemDTO, 1);
        assertEquals(expected, result, "Method runningTotalVAT does not return expected correct value.");

    }

    @Test
    void testRunningTotalVATWithZeroVAT() {
        itemDTO = new ItemDTO("abc123", "item1", 28.20, 0, "some description");
        double expected = 0.0;
        double result = total.runningTotalVAT(itemDTO, 1);
        assertEquals(expected, result, "Method runningTotalVAT does not return expected value.");

    }

    @Test
    void testUpdateQuantity() {
        total.setQuantity(1);
        int result = total.updateQuantity(1);
        int expected = 2;
        assertEquals(expected, result,
                "The test failed because the updated quantity does not match the expected value.");
    }

    @Test
    void testToStringReturnsTotalPrice() {
        itemDTO = new ItemDTO("abc123", "item1", 28.20, 0, "some description");
        total.runningTotal(itemDTO, 1);
        double totalPrice = total.getTotalPrice();
        String expected = "Total cost (incl VAT): " + totalPrice;
        String result = total.toString();
        assertTrue(result.contains(expected), "Total price not found in toString result.");
    }

}
