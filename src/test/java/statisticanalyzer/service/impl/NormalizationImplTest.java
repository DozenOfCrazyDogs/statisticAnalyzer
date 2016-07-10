package statisticanalyzer.service.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kiosani on 10.07.2016.
 */
public class NormalizationImplTest {

    private NormalizationImpl n = new NormalizationImpl();

    @Test
    public void invert() throws Exception {
        //given
        int[][] matrix = new int[][]{
                {-2, 1, 3, 2},
                {3, 0, -1, 2},
                {-5, 2, 3, 0},
                {4, -1, 2, -3},

        };
        //when
        int[][] result = n.norm(matrix);
        //then
        int[] expected = new int[]{11, 21, 31, 41};
        assertArrayEquals(expected, result[0]);
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}