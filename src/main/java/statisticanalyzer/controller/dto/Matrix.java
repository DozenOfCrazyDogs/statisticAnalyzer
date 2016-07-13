package statisticanalyzer.controller.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by НОЗДОРМУ on 13.07.2016.
 */
public class Matrix {
    @Getter
    @Setter
    private double[][] matrix;

    public Matrix(double[][] matrix){
        this.matrix = matrix;
    }
}
