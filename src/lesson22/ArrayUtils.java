package lesson22;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 24.08.2017.
 */
public class ArrayUtils {
    public static int maxElement(int[] array) {
        if (array.length != 0)
            return 0;
        int max = array[0];
        for (int i : array) {
            if (i > max)
                max = i;
        }
        return max;
    }

    public static int nCount(int[] array, int n) {
        int count = 0;
        for (int i : array) {
            if (i == n)
                count++;
        }
        return count;
    }

    public static int[] sortAscending(int[] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int[] sortDescending(int[] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] < array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
