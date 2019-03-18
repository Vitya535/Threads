package threads;

public class MultiplyMatrices {

    public static int[][] multiply(int[][] matrixOne, int[][] matrixTwo) {
        int[][] result = new int[matrixOne.length][matrixTwo[0].length];
        int threadCount = Math.min(matrixTwo[0].length, matrixOne.length);
        int area = matrixOne.length / threadCount;

        MultiplyMatrixThread[] multiplyMatrices = new MultiplyMatrixThread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            multiplyMatrices[i] = new MultiplyMatrixThread(matrixOne, matrixTwo, result, i * area, (i + 1) * area);
            multiplyMatrices[i].start();
        }

        for (MultiplyMatrixThread matrix : multiplyMatrices) {
            try {
                matrix.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
