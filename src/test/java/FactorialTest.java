
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class FactorialTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, Factorial.calculate(0));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, Factorial.calculate(1));
    }

    @Test
    void testFactorialOfRandomNumbers() {
        assertEquals(2, Factorial.calculate(2));
        assertEquals(6, Factorial.calculate(3));
        assertEquals(24, Factorial.calculate(4));
        assertEquals(120, Factorial.calculate(5));
    }

    @Test
    void testFactorialThrowsExceptionForNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
        assertEquals("Number must be non-negative", exception.getMessage());
    }
}