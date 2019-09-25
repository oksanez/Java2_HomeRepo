package main.java.lessonTwo.homework;

/**
 * Java. Уровень 2. Урок 2
 *
 * @author Oksana Nezlobina
 * @version 2019-09-24
 */
public class Main {


    public static void main(String[] args) {

        String stroka = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        String[][] twoDimensionalArray = arrayConversion(stroka);
        float sumInhalf = elementConversion(twoDimensionalArray);
        System.out.println("Результат: " + sumInhalf);
    }


    /**
     * Метод преобразования заданной строки в двумерный массив типа String[][]
     * @param s
     * @return String[][]
     */
    static String[][] arrayConversion(String s) throws ArrayIndexOutOfBoundsException {

        String[] matrixRow = s.split("\n");
        String[] matrixColumn;

        if(matrixRow.length != 4) throw new ArraySizeExeption("Размер получаенной матрицы не равен 4x4!");

        String[][] twoDimensionalArray = new String[matrixRow.length][matrixRow.length];

            for (int i = 0; i < twoDimensionalArray.length; i++) {
                for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                    matrixColumn = matrixRow[i].split(" ");
                    twoDimensionalArray[i][j] = matrixColumn[j];
                }
            }

        return twoDimensionalArray;
    }

    public static float elementConversion(String[][] array) throws ArrayIndexOutOfBoundsException, NumberFormatException {

        int sum = 0;

        int[][] convertedArray = new int[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                convertedArray[i][j] = Integer.parseInt(array[i][j]);
                sum += convertedArray[i][j];
            }
        }
        return sum/2;
    }
}