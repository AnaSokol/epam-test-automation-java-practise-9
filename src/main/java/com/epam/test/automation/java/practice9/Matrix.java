package com.epam.test.automation.java.practice9;

import java.text.DecimalFormat;

public class Matrix {
    public static final String INCOMPATIBLE_MATRIX_SIZES = "Incompatible matrix sizes";
    private int numberOfRows;
    private int numberOfColumns;
    double[][] m;

    Matrix(int row, int column){
        this.numberOfRows = row;
        this.numberOfColumns = column;
        this.m = new double[row][column];
    }
    Matrix(double[][] twoDimensionalArray) throws MatrixException {
        if (twoDimensionalArray.length == 0) {
            throw new MatrixException("Array passed with zero number of rows");
        }
        if (twoDimensionalArray[0].length == 0) {
            throw new MatrixException("Array passed with zero number of columns");
        }
        this.m = twoDimensionalArray;
        this.numberOfRows = this.m.length;
        this.numberOfColumns = this.m[0].length;
    }

    public final int rows() {
        return numberOfRows;
    }

    public final int columns() {
        return numberOfColumns;
    }

    public double getValue(int row, int column) throws MatrixException {
        if (m.length <= row || row < 0 || m[0].length <= column || column < 0){
            throw new MatrixException(INCOMPATIBLE_MATRIX_SIZES);
        }
        return m[row][column];
    }

    public void setValue(int row, int column, double newValue) throws MatrixException {
        if (m.length < row || row <= 0 || m[0].length < column || column <= 0){
            throw new MatrixException(INCOMPATIBLE_MATRIX_SIZES);
        }
        m[row][column] = newValue;
    }

    public double[][] twoDimensionalArrayOutOfMatrix() {
        return m;
    }

    public Matrix addition(Matrix matrix) throws MatrixException {
        if (matrix.twoDimensionalArrayOutOfMatrix().length != this.m.length ||
                matrix.twoDimensionalArrayOutOfMatrix()[0].length != this.m[0].length){
            throw new MatrixException(INCOMPATIBLE_MATRIX_SIZES);
        }
        double[][] temp = new double[numberOfRows][numberOfColumns];
        for(int i=0; i<numberOfRows; i++) {
            for (int j=0; j<numberOfColumns; j++) {
                temp[i][j] = this.m[i][j]+matrix.twoDimensionalArrayOutOfMatrix()[i][j];
            }
        }
        return new Matrix(temp);
    }

    public Matrix subtraction(final Matrix matrix) throws MatrixException {
        double[][] matrixSubtracted = matrix.twoDimensionalArrayOutOfMatrix();
        if (matrixSubtracted.length != this.m.length ||
                matrixSubtracted[0].length != this.m[0].length) {
            throw new MatrixException(INCOMPATIBLE_MATRIX_SIZES);
        }
        double[][] temp = new double[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                temp[i][j] = this.m[i][j] - matrixSubtracted[i][j];
            }
        }
        return new Matrix(temp);
    }

    public Matrix multiplication(final Matrix matrix) throws MatrixException {
        double[][] multiplier = matrix.twoDimensionalArrayOutOfMatrix();
        if (multiplier.length != this.m[0].length ||
                multiplier[0].length != this.m.length ){
            throw new MatrixException(INCOMPATIBLE_MATRIX_SIZES);
        }
        double[][] temp = new double[numberOfRows][matrix.columns()];
        for(int i=0; i<numberOfRows; i++){
            for(int j=0; j<matrix.columns(); j++) {
                temp[i][j]=0;
                for(int k=0; k<matrix.rows(); k++) {
                    temp[i][j]+=this.m[i][k]*multiplier[k][j];
                }//end of k loop
            }//end of j loop
        }
        return new Matrix(temp);
    }


    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                try {
                    if (j != this.columns() - 1) {
                        builder.append(decimalFormat.format(getValue(i, j)) + " ");
                    } else {
                        builder.append(decimalFormat.format(getValue(i, j)));
                    }
                } catch (MatrixException e) {
                    e.getMessage();
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}