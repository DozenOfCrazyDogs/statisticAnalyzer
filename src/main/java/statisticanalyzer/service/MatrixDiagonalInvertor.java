package java.hello.service;

/**
 * Created by Igor on 09.07.2016.
 */
public class MatrixDiagonalInvertor {

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
