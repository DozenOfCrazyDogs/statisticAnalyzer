package statisticanalyzer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import statisticanalyzer.service.Normalization;

/**
 * Created by Kiosani on 09.07.2016.
 */

@Service
@Slf4j
public class NormalizationImplPaxan implements Normalization {

    public double[][] norm(double input[][]) {

        double[][] result = new double[input.length][input[0].length];
        double[] avg = average(input);
        double[] dev = deviation(input, avg);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (dev[j] == 0) {
                    result[i][j] = 0;
                    log.info("[" + i + "][" + j + "]");
                }
                else {
                    result[i][j] = (input[i][j] - avg[j])/dev[j];
                    log.info("[" + i + "][" + j + "]");
                }
            }
        }

        return result;
    }

    private int determinant(int mtrx[][]) {

        int det = 1;

        if  (mtrx[0][0] == 0) {
            for (int i = 1; i < mtrx.length; i++) {
                if (mtrx[i][0] != 0) {
                    int[] mas1 = new int[mtrx.length];
                    for (int j = 0; j < mtrx.length; j++) {
                        mas1[j] = mtrx[0][j];
                        mtrx[0][j] = mtrx[i][j];
                        mtrx[i][j] = mas1[j];
                    }
                    break;
                }
                else {
                    //break & metka do returna
                }
            }
        }

        //LU
        /*int[][] u = new int[mtrx.length][mtrx.length];
        int[][] l = new int[mtrx.length][mtrx.length];*/

        /*for (int i = 0; i < mtrx.length; i++) {
            u[0][i] = mtrx[0][i];
        }
        for (int i = 1; i < mtrx.length; i++) {
            l[i][0] = mtrx[i][0] / u[0][0];
        }
        for (int i = 1; i < mtrx.length; i++) {
            for (int j = i; j < mtrx.length; j++) {
                int u_temp = mtrx[i][j];
                for (int k = 0; k < i - 1; k++) {
                    u_temp = u_temp + l[i][k]*u[k][j];
                }
                u[i][j] = u_temp;
            }
            for (int j = i + 1; j < mtrx.length; j++) {
                int sum_l_temp = 0;
                for (int k = 0; k < i - 1; k++) {
                    sum_l_temp = sum_l_temp + l[j][k]*u[k][i];
                }
                l[j][i] = (mtrx[j][i]-sum_l_temp) / u[i][i];
            }
        }*/

        /*for (int j = 0; j < mtrx.length; j++) {
            for (int i = 0; i < mtrx.length; i++) {
                if (i <= j) {
                    u[i][j] = mtrx[i][j];
                    for (int k = 0; k < i - 1; k++) {
                        u[i][j] = l[i][k]*u[k][j];
                    }
                    if (i == j) {
                        l[i][j] = 1;
                    }
                    else {
                        l[i][j] = 0;
                    }
                }
                else {
                    l[i][j] = mtrx[i][j];
                    for (int k = 0; k < j - 1; k++) {
                        l[i][j] = l[i][k]*u[k][j];
                    }
                    l[i][j] = l[i][j] / u[i][j];
                    u[i][j] = 0;
                }
            }
        }



        int det_L = l[0][0];
        int det_U = u[0][0];
        for (int i = 1; i < mtrx.length; i++) {
            det_L = det_L * l[i][i];
            det_U = det_U * u[i][i];
        }

        det = det_L * det_U;*/



        return det;

    }

    private double[] deviation(double mtrx[][], double avg_calc[]) {

        double[] dev_calc = new  double[mtrx[0].length];

        for (int j = 0; j < mtrx[0].length; j++) {
            double dev_temp_for_column = 0;
            for (int i = 0; i < mtrx.length; i++) {
                dev_temp_for_column = dev_temp_for_column + Math.pow((mtrx[i][j] - avg_calc[j]), 2);
            }
            dev_calc[j] = Math.sqrt(dev_temp_for_column / mtrx.length);
            log.info(" Deviation [" + j + "][" + dev_calc[j] + "]");
        }

        return dev_calc;
    }

    private double[] average(double mtrx[][]) {
        double[] avg_calc = new double[mtrx[0].length];

        for (int j = 0; j < mtrx[0].length; j++) {
            avg_calc[j] = 0;
            for (int i = 0; i < mtrx.length; i++) {
                avg_calc[j] = avg_calc[j] + mtrx[i][j];
            }
            avg_calc[j] = avg_calc[j] / mtrx.length;
            log.info(" Average [" + j + "][" + avg_calc[j] + "]");
        }
        return avg_calc;
    }
}
