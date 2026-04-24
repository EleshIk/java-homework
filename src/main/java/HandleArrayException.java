public class HandleArrayException {

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("В массиве не 4 элемента");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("В элементе массива [" + i + "] не 4 элемента");
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "]: лежат неверные данные");
                }
            }
        }
        return sum;
    }
}