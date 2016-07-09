package statisticanalyzer.service.impl;

import statisticanalyzer.service.Dispersion;

/**
 * Created by Neifn on 09/07/2016.
 */
public class DispersionImplSanya implements Dispersion {
    @Override
    public int[] disp(int[][] matrix) {





        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int sum = 0;
                sum = sum + matrix[i][j]*matrix[j][i];
                double disp = Math.sqrt(sum * ((matrix[i][j]-matrix[j][i])*(matrix[i][i]-matrix[j][i])));


                System.out.print(disp + " ");
            }
        }
            return new int[0];
    }
}
