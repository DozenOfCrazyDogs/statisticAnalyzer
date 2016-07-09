package statisticanalyzer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Igor on 09.07.2016.
 */
public class MatrixTranponationsIgorTest {

    @Test
    public void myMeth() {
        int[] matrix = new int[]
                {11, 12, 13, 14
                };

        MatrixTranponationsIgor obj = new MatrixTranponationsIgor();

        int[] result = obj.transponate(matrix);

        int[] expected = {14,12,13,11};

        assertArrayEquals(expected, result);
    }

}