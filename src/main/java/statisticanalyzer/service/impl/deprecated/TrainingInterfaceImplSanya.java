package statisticanalyzer.service.impl.deprecated;

import org.mockito.internal.util.collections.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Neifn on 16/07/2016.
 */
public class TrainingInterfaceImplSanya implements TrainingInterface {
    @Override
    public double findMax(double[] array) {
        double Max = array[0];
        for (int i = 0; i < array.length; i++){ //програма берет одно значение и сравнивает его со всеми остальными
            if (Max < array[i])         // если выбранное значение меньше сравнимаего выбирается большее значение и цикл продолжается
                Max=array[i];
        }

        return Max;
    }

    @Override
    public double finxMin(double[] array) {
        double Min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (Min > array[i])
                Min = array[i];
        }
        return Min;
    }

    @Override
    public double[] findMaxAndMin(double[] array) {
        double Min = array[0];
        double Max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (Min > array[i])
                Min = array[i];
            if (Max < array[i])
                Max=array[i];
        }

        return new double[0];
    }

    @Override
    public double[] uniteTwoArraysIntoOne(double[] array1, double[] array2) {
        if (array1 == null) // если массив пустой переходим к обработке другого массива
            return  array2;
        if (array2 == null)
            return  array1;
        double[] arraysum =  new double[array1.length + array2.length];
        return arraysum;

    }

    @Override
    public double[] sumArrays(double[] array1, double[] array2) {
        double [] arraysum = new double[0];
        for (int i=0; i<array1.length; i++) {
            arraysum[i] = array1[i] + array2[i];
        }

        return arraysum;

    }

    @Override
    public double[] multiplyArrays(double[] array1, double[] array2) {
        double [] arraym= new double[0];
        for (int i=0; i<array1.length; i++) {
            arraym[i] = array1[i] * array2[i];
        }
        return arraym;
    }

    @Override
    public double[] findSumOfArray(double[] array) {
        double sum = 0;
        for (int i = 0; i<array.length; i++){
            sum=sum+array[i];
        }
        return new double[0];
    }

    @Override
    public double findAverage(double[] array) {
        double avg = 0;

        for (int i = 0; i<array.length; i++){
            avg=(avg+array[i])/array.length;
        }
        return avg;
    }

    @Override
    public double[][] fillWIthOne(double[][] matrix) {
        int num = 1;
        Arrays.fill(matrix, num);
        return matrix;
    }

    @Override
    public double[][] fillFirstAndLastRow(double[][] matrix) {

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; i++) {
                matrix[0][j] = 1;
                matrix[matrix.length][0] = 1;
            }
        }
        return matrix;
    }

    @Override
    public double[][] fillFirstAndLastColumn(double[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++){
            for (int j = 0; j < matrix.length; i++){
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
                matrix[i][j] = matrix[i+j][j+i];
            }
        }

        return matrix;
    }

    @Override
    public double[][] frameFill(double[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++){
            for (int j = 0; j < matrix.length; i++){
                matrix[i][0] = 1;
                matrix[i][matrix.length] =1;
                matrix[0][j] = 1;
                matrix[matrix.length][0] = 1;

            }
        }
        return matrix;
    }

    @Override
    public double[][] fillDiagonal(double[][] matrix) {
        for (int i = 0; i<matrix[0].length; i++){
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
        for (int i = 0; i<matrix[0].length; i++){
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
    public double[][] fillCorners(double[][] matrix) {
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
                matrix[i][j]=j;
            }
        }
        return matrix;
    }

    @Override
    public double[] sort(double[] array) {
        Arrays.sort(array);
        return array;
    }

    @Override
    public double[][] sortMatrixByRows(double[][] matrix) {
        Arrays.sort(matrix);
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
