import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NumberComparatorTest {

    @Test
    @Order(1)
    @DisplayName("Сравнение: первое число больше второго")
    void testCompareGreater() {
        assertEquals(1, NumberComparator.compare(10, 5));
        assertEquals(1, NumberComparator.compare(100, 1));
        assertEquals(1, NumberComparator.compare(0, -5));
    }

    @Test
    @Order(2)
    @DisplayName("Сравнение: первое число меньше второго")
    void testCompareLess() {
        assertEquals(-1, NumberComparator.compare(3, 7));
        assertEquals(-1, NumberComparator.compare(-10, 0));
        assertEquals(-1, NumberComparator.compare(1, 100));
    }

    @Test
    @Order(3)
    @DisplayName("Сравнение: числа равны")
    void testCompareEqual() {
        assertEquals(0, NumberComparator.compare(5, 5));
        assertEquals(0, NumberComparator.compare(0, 0));
        assertEquals(0, NumberComparator.compare(-5, -5));
    }
}