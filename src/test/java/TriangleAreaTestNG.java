import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TriangleAreaTestNG {

    private static final double DELTA = 0.001;

    @Test(priority = 1, groups = {"triangle"})
    public void testAreaByBaseAndHeight() {
        assertEquals(TriangleArea.calculateArea(5, 4), 10.0, DELTA);
        assertEquals(TriangleArea.calculateArea(3, 5), 7.5, DELTA);
        assertEquals(TriangleArea.calculateArea(1, 5), 2.5, DELTA);
    }

    @Test(priority = 2, groups = {"triangle"})
    public void testAreaByBaseAndHeightDouble() {
        assertEquals(TriangleArea.calculateArea(2.5, 3), 3.75, DELTA);
        assertEquals(TriangleArea.calculateArea(5, 1.7), 4.25, DELTA);
    }

    @Test(priority = 3, groups = {"triangle"})
    public void testAreaWithLargeNumbers() {
        assertEquals(TriangleArea.calculateArea(1000, 500), 250000.0, DELTA);
    }

    @Test(priority = 4, groups = {"triangle"})
    public void testAreaWithZero() {
        // Ноль должен работать (0.5 * base * 0 = 0)
        assertEquals(TriangleArea.calculateArea(10, 0), 0.0, DELTA);
        assertEquals(TriangleArea.calculateArea(0, 10), 0.0, DELTA);
    }

    // Тест с DataProvider
    @Test(priority = 5, groups = {"triangle"}, dataProvider = "areaData")
    public void testAreaWithDataProvider(double base, double height, double expected) {
        assertEquals(TriangleArea.calculateArea(base, height), expected, DELTA);
    }

    @DataProvider(name = "areaData")
    public Object[][] areaData() {
        return new Object[][] {
                {5, 4, 10.0},
                {3, 5, 7.5},
                {1, 5, 2.5},
                {2.5, 3, 3.75},
                {10, 0, 0.0}
        };
    }
}
