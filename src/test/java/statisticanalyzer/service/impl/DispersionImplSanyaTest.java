package statisticanalyzer.service.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Neifn on 09/07/2016.
 */
public class DispersionImplSanyaTest {
    private DispersionImplSanya  dispersion1 = new DispersionImplSanya();
    @Test
    public void invert() throws Exception {
        //given
        int[][] matrix = new int[][]{
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34},
                {41, 42, 43, 44},

        };
        //when
        printMatrix(matrix);
        int[] result = dispersion1.disp(matrix);
        //then

    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("abc");
            System.out.println();
        }
    }
}