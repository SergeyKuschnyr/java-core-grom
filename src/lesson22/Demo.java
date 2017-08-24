package lesson22;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 24.08.2017.
 */
public class Demo {
    public static void main(String[] args) {
        int[] array = {1, 34, 2, 9, 45, 47, 9, 77, 5, 8, 19};
        System.out.println(Arrays.toString(array));
        System.out.println(ArrayUtils.nCount(array, 9));
        System.out.println(ArrayUtils.sortAscending(array));
    }
}
