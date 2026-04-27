import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TriangleAreaTest {

    private static final double DELTA = 0.001; // точность для double

    @Test
    @Order(1)
    @DisplayName("Числа не дробные")
    void testAreaByBaseAndHeight() {
        assertEquals(10.0, TriangleArea.calculateArea(5, 4), DELTA);
        assertEquals(7.5, TriangleArea.calculateArea(3, 5), DELTA);
        assertEquals(2.5, TriangleArea.calculateArea(1, 5), DELTA);
    }

    @Test
    @Order(2)
    @DisplayName("дробные числа")
    void testAreaByBaseAndHeightDouble() {
        assertEquals(3.75, TriangleArea.calculateArea(2.5, 3), DELTA);
        assertEquals(4.25, TriangleArea.calculateArea(5, 1.7), DELTA);
    }
}