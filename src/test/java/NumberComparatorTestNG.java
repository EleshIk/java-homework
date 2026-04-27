import org.testng.annotations.*;
import static org.testng.Assert.*;

public class NumberComparatorTestNG {

    @Test(priority = 1)
    public void testCompareGreater() {
        assertEquals(NumberComparator.compare(10, 5), 1);
        assertEquals(NumberComparator.compare(100, 1), 1);
        assertEquals(NumberComparator.compare(0, -5), 1);
    }

    @Test(priority = 2)
    public void testCompareLess() {
        assertEquals(NumberComparator.compare(3, 7), -1);
        assertEquals(NumberComparator.compare(-10, 0), -1);
        assertEquals(NumberComparator.compare(1, 100), -1);
    }

    @Test(priority = 3)
    public void testCompareEqual() {
        assertEquals(NumberComparator.compare(5, 5), 0);
        assertEquals(NumberComparator.compare(0, 0), 0);
        assertEquals(NumberComparator.compare(-5, -5), 0);
    }
}