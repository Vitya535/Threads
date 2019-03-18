package threads;

/**
 * my thread for shell sort
 *
 * @author Кушнеренко Виктор
 */
public class ShellSortThread extends Thread {

    private int step;
    private int[] array;

    public ShellSortThread(int step, int[] array) {
        this.step = step;
        this.array = array;
    }

    @Override
    public void run() {
        int j;
        for (int i = step; i < array.length; i++) {
            int value = array[i];
            for (j = i - step; j >= 0 && array[j] > value; j -= step) {
                array[j + step] = array[j];
            }
            array[j + step] = value;
        }
    }
}
