package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductWithPieceTest {

    private ProductWithPiece pwp1 = new ProductWithPiece(Type.MEAT);
    private ProductWithPiece pwp2 = new ProductWithPiece(Type.BAKERY);
    private ProductWithPiece pwp3 = new ProductWithPiece(Type.MEAT);

    @Test
    void incrementCount() {
        pwp1.incrementCount();
        assertEquals(2, pwp1.getCount());
    }

    @Test
    void testEquals() {
        assertFalse(pwp1.equals(pwp2));
        assertTrue(pwp1.equals(pwp3));
    }

    @Test
    void getType() {
        assertEquals(Type.MEAT, pwp1.getType());
    }

    @Test
    void getCount() {
        assertEquals(1, pwp1.getCount());
    }
}