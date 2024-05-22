Кристијан Крстевски, бр. на индекс 223162

Control Flow Graph

Во кодот SILab2 со коментар ми се означени сите линии

![CFG](https://github.com/KristijanKrstevski/SI_2024_lab2_223162/assets/163184758/74496ae2-cafb-48d7-98f6-01941db27ebc)


Цикломатска комплексност

Цикломатската комплексност на овој код е 10, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност изнесува 10.

Тест случаи според критериумот Every Branch

![Every Branch](https://github.com/KristijanKrstevski/SI_2024_lab2_223162/assets/163184758/dc44e83a-ae5a-438a-b457-76cf7d848973)


Објаснување за напишаните тестови
Има 10 тестови:

Тест Случај 1: allItems е null
Влез: allItems = null, payment = 1000
Објаснување:
Методот прво проверува дали allItems е null.Бидејќи allItems е null, веднаш ќе фрли RuntimeException со порака "allItems листата не може да биде null!"

Тест Случај 2: Празна листа на предмети
Влез: allItems = [], payment = 1000
Објаснување:
Влезната листа на предмети е празна.Бидејќи листата е празна, веднаш ќе врати true.

Тест Случај 3: Предмет со null име
Влез: allItems = [new Item(null, "12345", 100, 0)], payment = 1000
Објаснување:
Листата содржи еден предмет со null име.Методот проверува дали allItems е null или празна.Методот поминува низ листата и открива дека името на предметот е null.Името на предметот се поставува на "unknown".

Тест Случај 4: Предмет со невалиден баркод
Влез: allItems = [new Item("item1", "12A45", 100, 0)], payment = 1000
Објаснување:
Листата содржи еден предмет со невалиден баркод.Методот поминува низ листата и открива дека името и баркодот на предметот не се null.Бидејќи баркодот содржи невалиден знак ('A'), фрла RuntimeException со порака "Invalid character in item barcode!"

Тест Случај 5: Предмет без баркод
Влез: allItems = [new Item("item1", null, 100, 0)], payment = 1000
Објаснување:	
Листата содржи еден предмет без баркод.Методот фрла RuntimeException со порака "No barcode!"

Тест Случај 6: Предмет со попуст
Влез: allItems = [new Item("item1", "12345", 100, 0.2f)], payment = 1000
Објаснување:
Листата содржи еден предмет со попуст.Методот пресметува вкупната цена на предметите земајќи го предвид попустот (100 * (1 - 0.2) = 80).Вкупната сума се споредува со плаќањето. Вкупната сума (80) е помала од плаќањето (1000), па враќа true.

Тест Случај 7: Предмет со цена > 300, попуст и баркод што почнува со '0'
Влез: allItems = [new Item("item1", "012345", 350, 0.1f)], payment = 1000
Објаснување:
Листата содржи еден предмет со цена > 300, попуст и баркод што почнува со '0'.Методот пресметува вкупната цена на предметите земајќи го предвид попустот (350 * (1 - 0.1) = 315).Вкупната сума се споредува со плаќањето. Вкупната сума (315) е помала од плаќањето (1000), па враќа true.

Тест Случај 8: Предмет без попуст
Влез: allItems = [new Item("item1", "12345", 100, 0.0f)], payment = 1000
Објаснување:
Листата содржи еден предмет без попуст.Методот пресметува вкупната цена на предметите земајќи го предвид попустот (100 * (1 - 0.0) = 100).Вкупната сума се споредува со плаќањето. Вкупната сума (100) е помала од плаќањето (1000), па враќа true.

Тест Случај 9: Вкупната сума е поголема од плаќањето
Влез: allItems = [new Item("item1", "12345", 1000, 0)], payment = 500
Објаснување:
Листата содржи еден предмет без попуст и со висока цена.Методот пресметува вкупната цена на предметите земајќи го предвид попустот (1000 * (1 - 0.0) = 1000).купната сума се споредува со плаќањето. Вкупната сума (1000) е поголема од плаќањето (500), па враќа false.

Тест Случај 10: Предмет со цена > 300, попуст > 0, и баркод што почнува со '0'
Влез: allItems = [new Item("item1", "012345", 400, 0.1f)], payment = 1000
Објаснување:
Листата содржи еден предмет со цена > 300, попуст > 0, и баркод што почнува со '0'.Методот пресметува вкупната цена на предметите земајќи го предвид попустот (400 * (1 - 0.1) = 360).Вкупната сума се споредува со плаќањето. Вкупната сума (360) е помала од плаќањето (1000), па враќа true.




Multiple Condition критериумот

![MC](https://github.com/KristijanKrstevski/SI_2024_lab2_223162/assets/163184758/7d17fbe8-36bc-48e6-ab43-9c3b9482748b)


Тест случај 1: Сите услови се исполнети
Цена: $400
Попуст: 10%
Баркод: "0123456789"
Очекуван исход: Изврши ги сите услови.

Тест случај 2: Цената не е поголема од 300
Цена: $200
Попуст: 5%
Баркод: "0123456789"
Очекуван исход: Прескокни поради првиот услов.

Тест случај 3: Попустот не е поголем од 0
Цена: $350
Попуст: 0%
Баркод: "0123456789"
Очекуван исход: Прескокни поради вториот услов.

Тест случај 4: Првиот знак на баркодот не е '0'
Цена: $380
Попуст: 15%
Баркод: "1123456789"
Очекуван исход: Прескокни поради третиот услов.



Објаснување како се напишани unit тестовите за секој од критериумите

Критериум 1: Методот треба да фрли RuntimeException со порака "allItems list can't be null!" ако allItems е null.
    @Test
    void testAllItemsNull() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 1000));
        assertEquals("allItems list can't be null!", exception.getMessage());
    }
Критериум 2: Методот треба да врати true ако листата allItems е празна.
    @Test
    void testEmptyList() {
        List<Item> allItems = new ArrayList<>();
        assertTrue(SILab2.checkCart(allItems, 1000));
    }
    
Критериум 3: Методот треба да го постави името на предметот на "unknown" ако името е null или празно.
    @Test
    void testItemWithNameNull() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item(null, "12345", 100, 0));
        assertTrue(SILab2.checkCart(allItems, 1000));
        assertEquals("unknown", allItems.get(0).getName());
    }    

Критериум 4: Методот треба да фрли RuntimeException со порака "Invalid character in item barcode!" ако баркодот содржи невалидни знаци.
    @Test
    void testItemWithInvalidBarcode() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "12A45", 100, 0));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 1000));
        assertEquals("Invalid character in item barcode!", exception.getMessage());
    }
    
Критериум 5: Методот треба да фрли RuntimeException со порака "No barcode!" ако баркодот е null.
    @Test
    void testItemWithoutBarcode() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", null, 100, 0));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 1000));
        assertEquals("No barcode!", exception.getMessage());
    }
    
Критериум 6: Методот треба правилно да го пресмета попустот и да врати true ако вкупната сума е помала или еднаква на плаќањето
    @Test
    void testItemWithDiscount() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "12345", 100, 0.2f));
        assertTrue(SILab2.checkCart(allItems, 1000));
    }
 Критериум 7: Методот треба да ја намали сумата за 30 ако предметот има цена > 300, попуст и баркод што почнува со '0'.
    @Test
    void testItemWithPriceGreaterThan300DiscountAndBarcodeStartingWith0() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "012345", 350, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 1000));
    }

  Критериум 8: Методот треба правилно да ја пресмета сумата без попуст и да врати true ако вкупната сума е помала или еднаква на плаќањето.
    @Test
    void testItemWithoutDiscount() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "12345", 100, 0.0f));
        assertTrue(SILab2.checkCart(allItems, 1000));
    }
  Критериум 9: Методот треба да врати false ако вкупната сума е поголема од плаќањето.
    @Test
    void testTotalSumGreaterThanPayment() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "12345", 1000, 0));
        assertFalse(SILab2.checkCart(allItems, 500));
    }
Критериум 10: Методот треба правилно да ја намали сумата за 30 ако предметот има цена > 300, попуст > 0 и баркод што почнува со '0'.
    @Test
    void testTen() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("item1", "012345", 400, 0.1f));
        assertTrue(SILab2.checkCart(allItems, 1000));
    }
  

    
   

    
   



