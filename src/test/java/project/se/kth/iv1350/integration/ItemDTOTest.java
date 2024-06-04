package project.se.kth.iv1350.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemDTOTest {
    private ItemDTO itemDTO; 
    @BeforeEach
    void setUp(){
    }
    
    @Test
    void testEquals() {
        String name = "item1"; 
        String description = "some  description"; 
        double price = 28.20; 
        String itemId = "abc123"; 
        double VAT = 6;
        ItemDTO instance = new ItemDTO(itemId, name, price, VAT, description); 
        ItemDTO equalInstance = new ItemDTO(itemId, name, price, VAT, description); 
        boolean expected = true; 
        boolean result = instance.equals(equalInstance); 
        assertEquals(expected, result, "ItemDTO is not equal"); 
    }
    @Test
    void testNotEqualToJavaLangObj(){
        String name = "item1"; 
        String description = "some  description"; 
        double price = 28.20; 
        String itemId = "abc123"; 
        double VAT = 6;
        ItemDTO instance = new ItemDTO(itemId, name, price, VAT, description);  
        Object obj = new Object(); 
        boolean expected = false; 
        boolean result = instance.equals(obj); 
        assertEquals(expected, result, "ItemDTO is equal java lang obj");
    }
    @Test
    void testNotEqualToNull(){
        String name = "item1"; 
        String description = "some  description"; 
        double price = 28.20; 
        String itemId = "abc123"; 
        double VAT = 6;
        ItemDTO instance = new ItemDTO(itemId, name, price, VAT, description);  
        Object obj = null; 
        boolean expected = false; 
        boolean result = instance.equals(obj); 
        assertEquals(expected, result, "ItemDTO is equal null");
    }
    @Test
    void testNotEqualName(){
        String name = "item1"; 
        String description = "some  description"; 
        double price = 28.20; 
        String itemId = "abc123"; 
        double VAT = 6;
        ItemDTO instance = new ItemDTO(itemId, name, price, VAT, description); 
        ItemDTO instanceNotEqual = new ItemDTO(itemId, "differen name", price, VAT, description);
        boolean expected = false; 
        boolean result = instance.equals(instanceNotEqual); 
        assertEquals(expected, result, "Items with different name should not be considered equel.");
    }

    @Test
    void testNotEqualDecription(){
        String name = "item1"; 
        String description = "some  description"; 
        double price = 28.20; 
        String itemId = "abc123"; 
        double VAT = 6;
        ItemDTO instance = new ItemDTO(itemId, name, price, VAT, description);  
        ItemDTO instanceNotEqual = new ItemDTO(itemId, name, price, VAT, "diffrent desc");
        boolean expected = false; 
        boolean result = instance.equals(instanceNotEqual); 
        assertEquals(expected, result, "Items with different decription should not be considered equal.");
    }
    @Test
    void testNotEqualPrice(){
        String name = "item1"; 
        String description = "some  description"; 
        double price = 28.20; 
        String itemId = "abc123"; 
        double VAT = 6;
        ItemDTO instance = new ItemDTO(itemId, name, price, VAT, description);  
        ItemDTO instanceNotEqual = new ItemDTO(itemId, name, 22, VAT, description);
        boolean expected = false; 
        boolean result = instance.equals(instanceNotEqual); 
        assertEquals(expected, result, "Items with different price should not be considered equal.");
    }
    @Test
    void testNotEqualItemId(){
        String name = "item1"; 
        String description = "some  description"; 
        double price = 28.20; 
        String itemId = "abc123"; 
        double VAT = 6;
        ItemDTO instance = new ItemDTO(itemId, name, price, VAT, description);  
        ItemDTO instanceNotEqual = new ItemDTO("abc", name, price, VAT, description);
        boolean expected = false; 
        boolean result = instance.equals(instanceNotEqual); 
        assertEquals(expected, result, "Items with different IDs should not be considered equal.");
    }
    @Test
    void testNotEqualVAT(){
        String name = "item1"; 
        String description = "some  description"; 
        double price = 28.20; 
        String itemId = "abc123"; 
        double VAT = 6;
        ItemDTO instance = new ItemDTO(itemId, name, price, VAT, description);  
        ItemDTO instanceNotEqual = new ItemDTO(itemId, name, price, 1, description);
        boolean expected = false; 
        boolean result = instance.equals(instanceNotEqual); 
        assertEquals(expected, result, "Items with different VAT should not be considered equal.");
    }
    @Test
    void testNotEqualNullParam(){
        String name = "item1"; 
        String description = "some  description"; 
        double price = 28.20; 
        String itemId = "abc123"; 
        double VAT = 6;
        ItemDTO instance = new ItemDTO(itemId, name, price, VAT, description);   
        ItemDTO instanceNotEqual = new ItemDTO(itemId, null, price, VAT, description);
        boolean expected = false; 
        boolean result = instance.equals(instanceNotEqual); 
        assertEquals(expected, result, "ItemDTO is equal null parameter");
    }
  
    @Test
    void testToString() {
        String itemName = "item1"; 
        String itemDescription = "some  description"; 
        double price = 28.20; 
        String itemId = "abc123"; 
        double itemVAT = 6;
        ItemDTO instance = new ItemDTO(itemId, itemName, price, itemVAT, itemDescription);   
        String expected = "Item ID: " + itemId + "\nItem name: " + itemName
                            + "\nItem cost: " + Double.parseDouble(String.format("%.1f",  price*(1+itemVAT/100))) + " SEK" + "\nVAT: " + itemVAT
                            + "\nItem description: " + itemDescription +"\n";

        String result = instance.toString(); 
            assertEquals(expected, result, "diffrent String than expected"); 
    }
    
    @Test
    void testToStringNullParameter(){
        String itemName = null; 
        String itemDescription = null; 
        double price = 0; 
        String itemId = null; 
        double itemVAT = 0;
        ItemDTO instance = new ItemDTO(itemId, itemName, price, itemVAT, itemDescription); 
        String expected ="Item ID: " + itemId + "\nItem name: " + itemName
        + "\nItem cost: " + Double.parseDouble(String.format("%.1f",  price*(1+itemVAT/100))) + " SEK" + "\nVAT: " + itemVAT
        + "\nItem description: " + itemDescription +"\n";
        String result = instance.toString(); 
        assertEquals(expected, result,"The toString method does not handle null parameters correctly.");  
    }
    
}
