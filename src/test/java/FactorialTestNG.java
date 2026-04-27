import org.testng.annotations.*;
import static org.testng.Assert.*;

public class FactorialTestNG {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.calculate(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Factorial.calculate(1), 1);
    }

    @Test
    public void testFactorialOfRandomNumbers() {
        assertEquals(Factorial.calculate(2), 2);
        assertEquals(Factorial.calculate(3), 6);
        assertEquals(Factorial.calculate(4), 24);
        assertEquals(Factorial.calculate(5), 120);
    }

    // Способ 1: expectedExceptions (проще)
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialThrowsExceptionForNegativeNumbers() {
        Factorial.calculate(-1);
    }

    // Способ 2: проверка сообщения исключения (детальнее)
    @Test
    public void testFactorialNegativeExceptionMessage() {
        try {
            Factorial.calculate(-1);
            fail("Должно было выброситься исключение");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Number must be non-negative");
        }
    }
}