package threads;

public class ShellSort {
    public static void sort(double step, double difference, int[] array) {
        int threadCount = (int) Math.ceil(step / difference - 1);

        ShellSortThread[] shellSortThreads = new ShellSortThread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            step -= difference;
            shellSortThreads[i] = new ShellSortThread((int) step, array);
            shellSortThreads[i].start();
        }

        for (ShellSortThread thread : shellSortThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
