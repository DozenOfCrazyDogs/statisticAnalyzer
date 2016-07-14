package statisticanalyzer.service.impl;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Igor on 11.07.2016.
 */
public class NormalizationMaxStrategyTest {

    private NormalizationMaxStrategy normilizer = new NormalizationMaxStrategy();

    @Test
    public void shouldWorkForDefaultNumbers() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {11, 142, 173},
                {121, 12, 139},
                {11, 112, 153},
                {131, 12, 133},
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then

        double[][] expected = new double[][]{
                {0.083969466, 1, 1},
                {0.923664122, 0.084507042, 0.803468208},
                {0.083969466, 0.788732394, 0.884393064},
                {1, 0.084507042, 0.768786127},

        };
        assertMatrixEquals(expected, result);
    }

    @Test
    public void shouldSetValueToZeroIfColumnCollectSameValues() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {11, 142, 173},
                {11, 12, 139},
                {11, 112, 153},
                {11, 12, 133},
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {1, 1, 1},
                {1, 0.084507042, 0.803468208},
                {1, 0.788732394, 0.884393064},
                {1, 0.084507042, 0.768786127},

        };
        assertMatrixEquals(expected, result);
    }

    @Test
    public void shouldWorkForNegativeValues() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {-11, -142, -173},
                {-11, -12, -139},
                {-14, -112, -153},
                {-15, -12, -133},
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {1, 11.83333333, 1.30075188},
                {1, 1, 1.045112782},
                {1.272727273, 9.333333333, 1.15037594},
                {1.363636364, 1, 1},

        };
        assertMatrixEquals(expected, result);
    }

    @Test
    public void shouldWorkForOneRow() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {-11, -142, -173}

        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {1, 1, 1}
        };
        assertMatrixEquals(expected, result);
    }

    @Test
    public void shouldWorkForOneColumn() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {-11},
                {-142},
                {-173}
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {1},
                {12.90909091},
                {15.72727273}
        };
        assertMatrixEquals(expected, result);
    }
  @Test
    public void shouldWorkForMatrixOnexOne() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {-11}
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {1}
        };
        assertMatrixEquals(expected, result);
    }

    @Test
    public void shouldWorkForNullForMax() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {-11, -142, -173},
                {0, -12, -139},
                {-14, -112, -153},
                {-15, -12, -133},
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {0, 11.83333333, 1.30075188},
                {0, 1, 1.045112782},
                {0, 9.333333333, 1.15037594},
                {0, 1, 1},

        };
        assertMatrixEquals(expected, result);
    }

    private void assertMatrixEquals(double[][] expected, double[][] result) {
        if (expected.length != result.length)
            Assert.fail("Rows are not equals: expected=" + expected.length + "; actual=" + result.length);
        if (expected[0].length != result[0].length)
            Assert.fail("Columns are not equals: expected=" + expected[0].length + "; actual=" + result[0].length);
        for (int i = 0; i < expected.length; i++)
            for (int j = 0; j < expected[0].length; j++)
                assertEquals(expected[i][j], result[i][j], 0.0001);
    }

    private void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(String.format("%.4f    ", matrix[i][j]));
            }
            System.out.println();
        }
    }
}