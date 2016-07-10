package statisticanalyzer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Igor on 09.07.2016.
 */
@Slf4j
public class NormalizationImplTest {

    private NormalizationImplJeka matrixDiagonalInvertor = new NormalizationImplJeka();

    @Test
    public void invert() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {11, 12, 133, 14},
                {21, 22, 232, 24},
                {31, 32, 335, 34},
                {41, 42, 434, 44},

        };
        //when
        printMatrix(matrix);
        double[][] result = matrixDiagonalInvertor.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {11, 21, 31, 41},
                {21, 22, 23, 24},
                {31, 32, 33, 34},
                {41, 42, 43, 44},

        };
    }

    private void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("abc");
            System.out.println();
        }
    }

}