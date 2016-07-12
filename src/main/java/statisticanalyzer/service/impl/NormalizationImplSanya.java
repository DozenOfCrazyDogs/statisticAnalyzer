package statisticanalyzer.service.impl;

import statisticanalyzer.service.Normalization;

/**
 * Created by Neifn on 12/07/2016.
 */
public class NormalizationImplSanya implements Normalization {
    @Override
    public double[][] norm(double[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            double avrG = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                avrG = avrG + matrix[i][j];
            }
            System.out.println(avrG + " rabotaet2");
            double averageG = avrG / matrix[0].length;

            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] / averageG;
                System.out.println(matrix);
            }
        }

        return matrix;
    }
}


