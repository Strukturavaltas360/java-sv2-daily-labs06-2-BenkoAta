package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store = new Store();
    Product p1 = new Product("darálthús", Type.MEAT, 1199);
    Product p2 = new Product("tarja", Type.MEAT, 1399);
    Product p3 = new Product("karaj", Type.MEAT, 1599);
    Product p4 = new Product("kenyér", Type.BAKERY, 399);

    @BeforeEach
    void init() {
        store.add(p1);
        store.add(p2);
        store.add(p3);
        store.add(p4);
    }

    @Test
    void addTest() {
        assertEquals(4, store.getProducts().size());
        assertSame(p3, store.getProducts().get(2));
    }

    @Test
    void numberOfProductsByTypeTest() {
        List<ProductWithPiece> stat = store.numberOfProductsByType();
        assertEquals(2, stat.size());
        assertEquals(Type.MEAT, stat.get(0).getType());
        assertEquals(3, stat.get(0).getCount());
        assertEquals(Type.BAKERY, stat.get(1).getType());
        assertEquals(1, stat.get(1).getCount());
    }

    @Test
    void numberOfProductsByTypeOnlyOneTest() {
        store = new Store();
        store.add(p1);
        store.add(p2);
        List<ProductWithPiece> stat = store.numberOfProductsByType();
        assertEquals(1, stat.size());
        assertEquals(Type.MEAT, stat.get(0).getType());
        assertEquals(2, stat.get(0).getCount());
    }

    @Test
    void numberOfProductsByTypeEmptyTest() {
        store = new Store();
        List<ProductWithPiece> stat = store.numberOfProductsByType();
        assertEquals(0, stat.size());
    }
}