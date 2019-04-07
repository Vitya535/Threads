package main;

import threads.ShellSort;

import java.util.Arrays;

/**
 * Entry point for shell sort
 *
 * @author Кушнеренко Виктор
 */
public class MainShellSort {

    public static void main(String[] args) {

        int[] array = {3, 5, 14, 24, 5, 3, 2, 7, 1};
        System.out.println(Arrays.toString(array));
        double step = 4;
        double difference = 1;

        ShellSort.sort(step, difference, array);

        System.out.println(Arrays.toString(array));
    }
}
