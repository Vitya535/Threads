package main;

import threads.MultiplyMatrices;

import java.util.Arrays;

/**
 * Entry point for multiply matrices
 *
 * @author Кушнеренко Виктор
 */
public class MainMultiplyMatrix {
    /**
     * field for result of the multiply two matrices
     */

    public static void main(String[] args) {
        int[][] matrixOne = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };
        int[][] matrixTwo = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        int[][] result = MultiplyMatrices.multiply(matrixOne, matrixTwo);

        System.out.println("First Matrix: " + Arrays.deepToString(matrixOne));
        System.out.println("Second Matrix: " + Arrays.deepToString(matrixTwo));
        System.out.println("Multiplied Matrix: " + Arrays.deepToString(result));
    }
}
