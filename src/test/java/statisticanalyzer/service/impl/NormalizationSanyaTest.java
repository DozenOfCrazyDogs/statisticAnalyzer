package statisticanalyzer.service.impl;

import org.junit.Test;

/**
 * Created by Neifn on 12/07/2016.
 */
public class NormalizationSanyaTest {
    private NormalizationImplSanya normaliazation = new NormalizationImplSanya();

    @Test
    public void invert() throws Exception {
        //given
        int[][] matrix = new int[][]{
                {11, 12, 13},
                {11, 12, 13},
                {11, 12, 13},
                {11, 12, 13},

        };
        //when
        printMatrix(matrix);
        double[][] result = normaliazation.norm(matrix);
        //then


    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("abc");
            System.out.println();
        }
    }
}
