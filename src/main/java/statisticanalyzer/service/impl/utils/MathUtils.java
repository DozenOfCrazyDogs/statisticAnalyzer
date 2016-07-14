package statisticanalyzer.service.impl.utils;

/**
 * Created by Igor on 12.07.2016.
 */
public class MathUtils {
    private final static double OBSERVATION = 0.0001;

    public static double getDispersion(double[] array) {
        double average = getAverage(array);
        return getDispersion(array, average);
    }

    public static double getDispersion(double[] array, double average) {
        double dispersion = 0;
        for (double element : array) {
            dispersion += ((element - average) * (element - average));
        }
        dispersion /= array.length;
        if (dispersion < OBSERVATION)
            dispersion = 0;
        return dispersion;
    }

    public static double getAverage(double[] array) {
        double average = 0;
        for (double element : array) {
            average += element;
        }
        average /= array.length;
        return average;
    }

    public static double getStandardDeviation(double[] array) {
        double average = getAverage(array);
        double dispersion = getDispersion(array, average);
        return Math.sqrt(dispersion);
    }

    public static double getStandardDeviation(double[] array, double average) {
        double dispersion = getDispersion(array, average);
        return Math.sqrt(dispersion);
    }

    public static double[] getColumnForMatrix(double[][] matrix, int columnIndex) {
        double[] array = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            array[i] = matrix[i][columnIndex];
        }
        return array;
    }

    public static double getMax(double array[]) {
        double max = array[0];
        for (double element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static double getMin(double array[]) {
        double min = array[0];
        for (double element : array) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }
}
