package statisticanalyzer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Igor on 09.07.2016.
 */
@Slf4j
public class MatrixDiagonalInvertorImplTest {

    private MatrixDiagonalInvertorImpl matrixDiagonalInvertor = new MatrixDiagonalInvertorImpl();

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
        int[][] result = matrixDiagonalInvertor.invert(matrix);
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