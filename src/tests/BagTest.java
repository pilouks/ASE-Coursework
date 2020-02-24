package tests;

import checkIn.Bag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class BagTest {

    Bag b;

    @BeforeEach
    void setUp() {
        b = new Bag(10.0, 10.0);
    }

    @Test
    void sizeTest() {
        assertEquals(b.getSize(), 10.0);
        b.setSize(20.0);
        assertEquals(b.getSize(), 20.0);
    }

    @Test
    void weightTest() {
        assertEquals(b.getWeight(), 10.0);
        b.setWeight(20.0);
        assertEquals(b.getWeight(), 20.0);
    }
}