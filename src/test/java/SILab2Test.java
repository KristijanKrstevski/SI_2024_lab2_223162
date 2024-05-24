import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

//    @Test
//    void checkCart() {
//    }


    //Критериум: Методот треба да фрли RuntimeException со порака "allItems list can't be null!" ако allItems е null.
    @Test
    void testAllItemsNull() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 1000));
        assertEquals("allItems list can't be null!", exception.getMessage());
    }

    //Критериум: Методот треба да врати true ако листата allItems е празна.
    @Test
    void testEmptyList() {
        List<Item> allItems = new ArrayList<>();
        assertTrue(SILab2.checkCart(allItems, 1000));
    }


    //Критериум: Методот треба да го постави името на предметот на "unknown" ако името е null или празно.
    @Test
    void testItemWithNameNull() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item(null, "12345", 100, 0));
        assertTrue(SILab2.checkCart(allItems, 1000));
        assertEquals("unknown", allItems.get(0).getName());
    }

    //Критериум: Методот треба да фрли RuntimeException со порака "Invalid character in item barcode!" ако баркодот содржи невалидни знаци.
    @Test
    void testItemWithInvalidBarcode() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "12A45", 100, 0));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 1000));
        assertEquals("Invalid character in item barcode!", exception.getMessage());
    }


    //Критериум: Методот треба да фрли RuntimeException со порака "No barcode!" ако баркодот е null.
    @Test
    void testItemWithoutBarcode() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", null, 100, 0));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 1000));
        assertEquals("No barcode!", exception.getMessage());
    }

    //Критериум: Методот треба правилно да го пресмета попустот и да врати true ако вкупната сума е помала или еднаква на плаќањето
    @Test
    void testItemWithDiscount() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "12345", 100, 0.2f));
        assertTrue(SILab2.checkCart(allItems, 1000));
    }

    //Критериум: Методот треба да ја намали сумата за 30 ако предметот има цена > 300, попуст и баркод што почнува со '0'.
    @Test
    void testItemWithPriceGreaterThan300DiscountAndBarcodeStartingWith0() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "012345", 350, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 1000));
    }

    //Критериум: Методот треба правилно да ја пресмета сумата без попуст и да врати true ако вкупната сума е помала или еднаква на плаќањето.
    @Test
    void testItemWithoutDiscount() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "12345", 100, 0.0f));
        assertTrue(SILab2.checkCart(allItems, 1000));
    }

    //Критериум: Методот треба да врати false ако вкупната сума е поголема од плаќањето.
    @Test
    void testTotalSumGreaterThanPayment() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "12345", 1000, 0));
        assertFalse(SILab2.checkCart(allItems, 500));
    }

    //Критериум: Методот треба правилно да ја намали сумата за 30 ако предметот има цена > 300, попуст > 0 и баркод што почнува со '0'.
    @Test
    void testTen() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "012345", 400, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 1000));
    }
}