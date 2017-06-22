package lesson3;

/**
 * Created by Kushn_000 on 10.03.2017.
 */
public class FindOdd {
    public static void main(String[] args) {
        int q = 0;
        int w = 0;

        while (q < 1000) {
            if (1 == (q % 2)) {
                System.out.println("Found");
                w += q;
            }
            q++;
        }
        if (w * 5 > 5000) {
            System.out.println("Bigger");
        } else {
            if (w * 5 < 5000)
                System.out.println("Smaller");
            else
                System.out.println("Equal");
        }

        // w = (w * 5 > 5000) ? 23 : 45;
    }
}
