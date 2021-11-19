package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product("darálthús", Type.MEAT, 1199);

    @Test
    void getName() {
        assertEquals("darálthús", product.getName());
    }

    @Test
    void getType() {
        assertEquals(Type.MEAT, product.getType());
    }

    @Test
    void getPrice() {
        assertEquals(1199, product.getPrice());
    }
}