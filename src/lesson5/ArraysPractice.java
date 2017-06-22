package lesson5;

/**
 * Created by Kushn_000 on 17.03.2017.
 */
public class ArraysPractice {
    public static void main(String[] args) {
        int[] array = {-10, 0, 110, 555, 1000, -45, 0, 60};
        int[] array2 = {};
        int[] array3 = {0, 0, 0, 0, 0, 0, 0};

        System.out.println(maxElement(array));
        System.out.println(nCount(array, 555));
        System.out.println(maxElement(array2));
        System.out.println(nCount(array2, 45));
        System.out.println(maxElement(array3));
        System.out.println(nCount(array3, 0));
    }

    public static int maxElement(int[] array) {
        if (array.length != 0) {
            int max = array[0];
            for (int i : array) {
                if (i > max)
                    max = i;
            }
            return max;
        }
        System.out.println("Empty array. Next value is non sens");
        return 0;
    }

    public static int nCount(int[] array, int n) {
        int count = 0;
        for (int i : array) {
            if (i == n)
                count++;
        }
        return count;
    }
}
