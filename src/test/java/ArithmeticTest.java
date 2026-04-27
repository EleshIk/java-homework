import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArithmeticTest {

    @Test
    @Order(1)
    @DisplayName("Тесты сложения")
    void testAddition() {
        assertEquals(5, Arithmetic.add(2, 3));
        assertEquals(-1, Arithmetic.add(-2, 1));
        assertEquals(0, Arithmetic.add(0, 0));
        assertEquals(100, Arithmetic.add(50, 50));
    }

    @Test
    @Order(2)
    @DisplayName("Тесты вычитания")
    void testSubtraction() {

        assertEquals(-1, Arithmetic.subtract(2, 3));
        assertEquals(5, Arithmetic.subtract(10, 5));
        assertEquals(0, Arithmetic.subtract(7, 7));
        assertEquals(-10, Arithmetic.subtract(-5, 5));
    }

    @Test
    @Order(3)
    @DisplayName("Тесты умножения")
    void testMultiplication() {
        assertEquals(15, Arithmetic.multiply(3, 5));
        assertEquals(-10, Arithmetic.multiply(-2, 5));
        assertEquals(0, Arithmetic.multiply(0, 100));
        assertEquals(100, Arithmetic.multiply(10, 10));
    }

    @Test
    @Order(4)
    @DisplayName("Тесты деления")
    void testDivision() {
        assertEquals(2.0, Arithmetic.divide(10, 5), 0.001);
        assertEquals(2.5, Arithmetic.divide(5, 2), 0.001);
        assertEquals(0.0, Arithmetic.divide(0, 5), 0.001);
    }
}