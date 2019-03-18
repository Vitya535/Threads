package threads;

/**
 * my thread class for multiply two matrices rapidly
 *
 * @author Кушнеренко Виктор
 */
public class MultiplyMatrixThread extends Thread {
    private int[][] matrixOne, matrixTwo, result;

    /**
     * this fields means a count of rows, which multiply by one thread
     */
    private int begin, end;

    public MultiplyMatrixThread(int[][] matrixOne, int[][] matrixTwo, int[][] result, int begin, int end) {
        this.matrixOne = matrixOne;
        this.matrixTwo = matrixTwo;
        this.result = result;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = begin; i < end; i++) {
            for (int j = 0; j < matrixTwo[0].length; j++) {
                int sum = 0;
                for (int r = 0; r < matrixTwo.length; r++) {
                    sum += matrixOne[i][r] * matrixTwo[r][j];
                }
                result[i][j] = sum;
            }
        }
    }
}
