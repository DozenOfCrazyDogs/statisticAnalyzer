package statisticanalyzer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import statisticanalyzer.service.MatrixDiagonalInvertor;

/**
 * Created by Igor on 09.07.2016.
 */
@Service
@Slf4j
public class MatrixDiagonalInvertorImpl implements MatrixDiagonalInvertor {

    public int[][] invert(int[][] input) {

        int[][] result = new int[input.length][input[0].length];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                result[j][i] = input[i][j];

            }
        }
        return result;
    }
}
