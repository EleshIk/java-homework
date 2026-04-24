
public class Main {
    public static void main(String[] args) {

        String[][] matrix = {
                {"1", "2", "3", "4"},
                {"5", "3", "1", "0"},
                {"3", "12", "32", "100"},
                {"545", "43", "99", "167"},

        };

        try {
            int sum = HandleArrayException.sumArray(matrix);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException error) {
            System.out.println(error.getMessage());
        }
    }
}