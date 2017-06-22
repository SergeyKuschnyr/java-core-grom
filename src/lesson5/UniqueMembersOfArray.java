package lesson5;

/**
 * Created by Kushn_000 on 19.03.2017.
 */
public class UniqueMembersOfArray {
    public static void main(String[] args) {
        int[] testArray = {12, 56, 93, 56, 900, 43, -67, 12};
        System.out.println(uniqueCount(testArray));
        int[] testArray2 = {};
        System.out.println(uniqueCount(testArray2));
        int[] testArray3 = {0, 0, 0};
        System.out.println(uniqueCount(testArray3));
    }

    public static int[] sortAscending(int[] arr) {
        int n = arr.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;
    }

    public static int uniqueCount(int[] array) {
        sortAscending(array);

        if (array.length != 0) {
            int count = 1;
            int prev = array[0];
            for (int element : array) {
                if (element != prev) {
                    prev = element;
                    count++;
                }
            }
            return count;
        }
        return 0;
    }
}
