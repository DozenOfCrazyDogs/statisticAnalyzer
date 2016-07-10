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

                int avr = matrix[i][j];
                avr = matrix[0][j] + matrix[0][j];
                double average = avr/matrix.length;
                System.out.println(average + " rabotaet1");
                double avrG = 0;
                avrG = avrG + matrix[i][j];
                double averageG = avrG/matrix.length;
                System.out.println(averageG + " rabotaet2");


                double sqr = (matrix[i][j] - averageG)*(matrix[i][j] - averageG);
                double sum = 0;
                sum = sum + sqr;
                double disp = Math.sqrt(sum/matrix.length);
                System.out.println(disp + "normas");
            }
        }
            return new int[0];
    }
}
