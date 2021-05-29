package com.epam.test.automation.java.practice9;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Matrix {
    private int numberOfRows;
    private int numberOfColumns;
    double[][] matrix;
    
    Matrix(int row, int column){
        this.numberOfRows = row;
        this.numberOfColumns = column;
        this.matrix = new double[row][column];
    }
    
    Matrix(double[][] twoDimensionalArray){
        this.matrix = twoDimensionalArray;
        this.numberOfRows = this.matrix.length;
        this.numberOfColumns = this.matrix[0].length;
    }

    public final int rows() {
        return numberOfRows;
    }

    public final int columns() {
        return numberOfColumns;
    }

    public double getValue(int row, int column) throws MatrixException {
        double value = matrix[row][column];
        return value;
    }

    public void setValue(int row, int column, double newValue) throws MatrixException {
        matrix[row][column] = newValue;
    }

    public double[][] twoDimensionalArrayOutOfMatrix() {
        return matrix;
    }

    public Matrix addition(Matrix matrix) {
        double[][] temp = new double[numberOfRows][numberOfColumns];
        for(int i=0; i<numberOfRows; i++) {
            for (int j=0; j<numberOfColumns; j++) {
                temp[i][j] = this.matrix[i][j]+matrix.twoDimensionalArrayOutOfMatrix()[i][j];
            }
        }
        Matrix result = new Matrix(temp);
        return result;
    }

    public Matrix subtraction(final Matrix matrix) {
        double[][] matrixSubstracted = matrix.twoDimensionalArrayOutOfMatrix();
        double[][] temp = new double[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                temp[i][j] = this.matrix[i][j] - matrixSubstracted[i][j];
            }
        }
        Matrix result = new Matrix(temp);
        return result;
    }

    public Matrix multiplication(final Matrix matrix) {
        double[][] multiplier = matrix.twoDimensionalArrayOutOfMatrix();
        double[][] temp = new double[numberOfRows][matrix.columns()];
        for(int i=0; i<numberOfRows; i++){
            for(int j=0; j<matrix.columns(); j++) {
                temp[i][j]=0;
                for(int k=0; k<matrix.rows(); k++) {
                    temp[i][j]+=this.matrix[i][k]*multiplier[k][j];
                }//end of k loop
            }//end of j loop
        }
        Matrix result = new Matrix(temp);
        return result;
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