import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ArithmeticTestNG {

    @Test(priority = 1)
    public void testAddition() {
        assertEquals(Arithmetic.add(2, 3), 5);
        assertEquals(Arithmetic.add(-2, 1), -1);
        assertEquals(Arithmetic.add(0, 0), 0);
        assertEquals(Arithmetic.add(50, 50), 100);
    }

    @Test(priority = 2)
    public void testSubtraction() {
        assertEquals(Arithmetic.subtract(2, 3), -1);
        assertEquals(Arithmetic.subtract(10, 5), 5);
        assertEquals(Arithmetic.subtract(7, 7), 0);
        assertEquals(Arithmetic.subtract(-5, 5), -10);
    }

    @Test(priority = 3)
    public void testMultiplication() {
        assertEquals(Arithmetic.multiply(3, 5), 15);
        assertEquals(Arithmetic.multiply(-2, 5), -10);
        assertEquals(Arithmetic.multiply(0, 100), 0);
        assertEquals(Arithmetic.multiply(10, 10), 100);
    }

    @Test(priority = 4)
    public void testDivision() {
        assertEquals(Arithmetic.divide(10, 5), 2.0, 0.001);
        assertEquals(Arithmetic.divide(5, 2), 2.5, 0.001);
        assertEquals(Arithmetic.divide(0, 5), 0.0, 0.001);
    }
}