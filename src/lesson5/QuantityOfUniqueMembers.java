package lesson5;

/**
 * Created by Kushn_000 on 20.03.2017.
 */
public class QuantityOfUniqueMembers {
    public static void main(String[] args) {
        int[] array = {78, 86, 34, -23, 11, -1, 88, 11, -1, -1, 86, 109};
        int[] array2 = {};
        int[] array3 = {0, 0, 0, 0, 0, 0};

        System.out.println(uniqueCount(array));
        System.out.println(uniqueCount(array2));
        System.out.println(uniqueCount(array3));

    }

    static int uniqueCount(int[] array) {
        if (array.length != 0) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                for (int t = 0; t < array.length; t++) {
                    if (i != t)
                        if (array[i] == array[t])
                            for (int q = t; q < (array.length - 1); q++)
                                array[q] = array[q + 1];
                }
            }
            for (int w = 0; w < array.length; w++)
                if (array[w] == array[(array.length - 1)])
                    count++;
            count = (array.length - count + 1);
            return count;
        }
        return 0;
    }
}
