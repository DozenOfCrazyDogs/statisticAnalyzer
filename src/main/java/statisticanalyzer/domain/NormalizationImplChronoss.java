package statisticanalyzer.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import statisticanalyzer.service.Normalization;

/**
 * Created by Igor on 11.07.2016.
 */
@Service
@Slf4j
public class NormalizationImplChronoss implements Normalization {
    private double OBSERVATION = 0.0001;

    @Override
    public double[][] norm(double[][] matrix) {

        for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) {
            double average = getAverageValeForColumn(matrix, columnIndex);
            double dispersion = getDispersionForColumn(matrix, average, columnIndex);
            double standardDeviation = getStandardDeviation(dispersion);

            for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
                double element = matrix[rowIndex][columnIndex];
                matrix[rowIndex][columnIndex] = normalizedValue(average, standardDeviation, element);
            }
        }
        return matrix;
    }


    private double getAverageValeForColumn(double[][] matrix, int columnIndex) {
        int rowCount = matrix.length;

        double average = 0;
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            double element = matrix[rowIndex][columnIndex];
            average += element;
        }
        average /= rowCount;
        return average;
    }

    private double getDispersionForColumn(double[][] matrix, double average, int columnIndex) {
        int rowCount = matrix.length;

        double dispersion = 0;
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            double element = matrix[rowIndex][columnIndex];
            dispersion += ((element - average) * (element - average));
        }
        dispersion /= rowCount;
        if (dispersion < OBSERVATION)
            dispersion = 0;
        return dispersion;
    }

    private double getStandardDeviation(double dispersion) {
        return Math.sqrt(dispersion);
    }

    private double normalizedValue(double average, double standardDeviation, double element) {
        if (standardDeviation == 0)
            return 0;
        return (element - average) / standardDeviation;
    }
}
