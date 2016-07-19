package statisticanalyzer.service.impl.deprecated;

import org.mockito.internal.util.collections.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Neifn on 16/07/2016.
 */
public class TrainingInterfaceImplSanya implements TrainingInterface {
    @Override
    public double findMax(double[] array) {    // Одна ненужная итерация
        double Max = array[0];
        for (int i = 0; i < array.length; i++){ //програма берет одно значение и сравнивает его со всеми остальными
            if (Max < array[i])         // если выбранное значение меньше сравнимаего выбирается большее значение и цикл продолжается
                Max=array[i];
        }

        return Max;
    }

    @Override
    public double finxMin(double[] array) {   // То же самое, одна ненужная итерация
        double Min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (Min > array[i])
                Min = array[i];
        }
        return Min;
    }

    @Override
    public double[] findMaxAndMin(double[] array) {  // То же самое
        double Min = array[0];
        double Max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (Min > array[i])
                Min = array[i];
            if (Max < array[i])
                Max=array[i];
        }

        return new double[0];                       // ??? что мы возвращаем тут? надо вернуть массив из двух чисел, минимум и максимум
    }

    @Override
    public double[] uniteTwoArraysIntoOne(double[] array1, double[] array2) {
        if (array1 == null) // если массив пустой переходим к обработке другого массива
            return  array2;
        if (array2 == null)
            return  array1;
        double[] arraysum =  new double[array1.length + array2.length];
        return arraysum;            // возвращаем пустой массив? =/

    }

    @Override
    public double[] sumArrays(double[] array1, double[] array2) {
        double [] arraysum = new double[0];     // неправильно, надо создать массив длинны большего массива из двух, и сделать два цикла, первый заполняет суммой элементов, а второй остатками элементов
        for (int i=0; i<array1.length; i++) {
            arraysum[i] = array1[i] + array2[i];
        }

        return arraysum;

    }

    @Override
    public double[] multiplyArrays(double[] array1, double[] array2) {
        double [] arraym= new double[0];        // то же самое что и в предыдущем
        for (int i=0; i<array1.length; i++) {
            arraym[i] = array1[i] * array2[i];
        }
        return arraym;
    }

    @Override
    public double[] findSumOfArray(double[] array) {
        double sum = 0;
        for (int i = 0; i<array.length; i++){
            sum=sum+array[i];               // можно упростить выражением sum+=array[i];
        }
        return new double[0];               // что мы возвращаем?
    }

    @Override
    public double findAverage(double[] array) {
        double avg = 0;

        for (int i = 0; i<array.length; i++){
            avg=(avg+array[i])/array.length; // лишние действия, делишь каждое число на количество=/ лучше посчитать сумму и вернуть return avg/array.length;
        }
        return avg;
    }

    @Override
    public double[][] fillWIthOne(double[][] matrix) {
        int num = 1;
        Arrays.fill(matrix, num);   // задание было на подумать, а не на использование библиотек=/
        return matrix;
    }

    @Override
    public double[][] fillFirstAndLastRow(double[][] matrix) {

        for (int i = 0; i < matrix[0].length; i++) { // этот цикл вообще здесь не нужен, i мы нигде не используем
            for (int j = 0; j < matrix.length; i++) {
                matrix[0][j] = 1;
                matrix[matrix.length][0] = 1;   // эта строчка неправильна, она только кладет единицу в одну ячейку
            }
        }
        return matrix;
    }

    @Override
    public double[][] fillFirstAndLastColumn(double[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++){
            for (int j = 0; j < matrix.length; i++){  // этот цикл не нужен, j мы нигде не используем
                matrix[i][0] = 1;
                matrix[i][matrix.length] =1;

            }

        }

        return matrix;
    }

    @Override
    public double[][] fillElementsForSumOfIndexes(double[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++){
            for (int j = 0; j < matrix.length; i++){
                matrix[i][j] = matrix[i+j][j+i];        // неправильно понял задание, это совсем неверно (кстати и почему ты везде делаешь перебор сначала по колонкам, а потом по рядкам?)
            }
        }

        return matrix;
    }

    @Override
    public double[][] frameFill(double[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++){    // неправильное ограничение, ты перебираешь рядки, но с ограничением в количество столбцов
            for (int j = 0; j < matrix.length; i++){
                matrix[i][0] = 1;
                matrix[i][matrix.length] =1;
                matrix[0][j] = 1;
                matrix[matrix.length][0] = 1;       // неправильно, ты заполняешь всего 1-н элемент, а надо весь ряд

            }
        }
        return matrix;
    }

    @Override
    public double[][] fillDiagonal(double[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++){    // опять неправильный перебор, см. выше, остальное все правильно
            for (int j = 0; j < matrix.length; i++){
                if (i == j){
                    matrix[i][j]=1;
                }
                else matrix[i][j] =0;
            }
        }
        return matrix;
    }

    @Override
    public double[][] fillSecondDiagonal(double[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++){       // здесь смотрю даже не делал, подсказка: надо заполнять с шагом в минус единицу для колонки с первого ряда до последнего
            for (int j = 0; j < matrix.length; i++){
                if (i == j) {

                }
            }
        }
        return new double[0][];
    }

    @Override
    public double[][] fillTwoDiagonals(double[][] matrix) {
        return new double[0][];
    }

    @Override
    public double[][] fillCorners(double[][] matrix) {  //неправильно! matrix.length не равно номеру последней ячейки! последний номер matrix.length-1 обрати внимание на это везде, там выше есть такая же ошибка, я не комментил
        matrix[0][0]=1;
        matrix [0][matrix.length] = 1;
        matrix[matrix.length][0]=1;
        matrix[matrix.length][matrix.length]=1;
        return matrix;
    }

    @Override
    public double[][] fillIncrementally(double[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++){ 
            for (int j = 0; j < matrix.length; i++){
                matrix[i][j]=j;  // дичь) matrix[i][j]=matrx[i][j-1]+1; вот так надо, предварительно поставив условие что первый элемент ноль, а первый элемент каждой новой строки matrix[i][0]=matrix[i-1][matrix[0].length-1];
            }
        }
        return matrix;
    }

    @Override
    public double[] sort(double[] array) {
        Arrays.sort(array);  // задание то на подумать!
        return array;
    }

    @Override
    public double[][] sortMatrixByRows(double[][] matrix) {
        Arrays.sort(matrix);        // на подумать 
        /*double[] columb = new double[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int y = 0; y < matrix.length; y++) {
                columb[y] = matrix[y][j];
            }
        }
        Arrays.sort(columb);*/
        return matrix;
    }
}
