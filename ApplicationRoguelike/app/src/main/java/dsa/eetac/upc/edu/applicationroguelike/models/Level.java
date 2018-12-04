package dsa.eetac.upc.edu.applicationroguelike.models;

import java.util.Arrays;

public class Level {

    private int idLevel;
    private int numRows,numColumns;
    private int [][] matrix;

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        return "Level{" +
                "idLevel=" + idLevel +
                ", numRows=" + numRows +
                ", numColumns=" + numColumns +
                ", matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
