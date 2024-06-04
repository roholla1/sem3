package project.se.kth.iv1350.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.se.kth.iv1350.integration.ItemDTO;

public class SaleDTOTest {
    private ItemDTO itemDTO; 
    private SaleDTO saleDTO; 
    
    @BeforeEach
    void setUP(){ 
        itemDTO = new ItemDTO("abc123", "item1", 28.20, 6, "some description");
        saleDTO = new SaleDTO(itemDTO, 5.0, 50.0, 1); 
    }

    @Test
    void testToString() {
        double totalPrice = saleDTO.getTotalPriceVATInc();
        double totalVAT = saleDTO.getTotalVAT();
        String totalPriceFormatted = String.format("%.1f", totalPrice);
        String totalVATFormatted = String.format("%.1f", totalVAT);
        String expected = itemDTO + "\nTotal cost (incl VAT):  " + totalPriceFormatted  +" SEK" + "\ntotalVAT: " + totalVATFormatted;
        String result = saleDTO.toString();
        assertEquals(expected, result);
    }
}

