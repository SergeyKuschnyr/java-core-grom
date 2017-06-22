package lesson4;

/**
 * Created by Kushn_000 on 12.03.2017.
 */
public class CompareSum {
    public static void main(String[] args) {
        System.out.println(compareSums(5, 20, 10, 25));
    }

    public static long sum(int from, int to) {
        int sum = from;
        for (long i = (from + 1); i <= to; i++) {
            System.out.print(sum + " + ");
            sum += i;
            System.out.println(i + " = " + sum);
        }

        System.out.println();

        return sum;
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        return sum(a, b) > sum(c, d);
    }
}
