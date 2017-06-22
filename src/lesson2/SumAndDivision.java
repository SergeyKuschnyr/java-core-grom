package lesson2;

/**
 * Created by Kushn_000 on 08.03.2017.
 */
public class SumAndDivision {
    public static void main(String[] args) {
        int q = 0;
        int w = 1000;
        long e = 0;
        while (q <= w){
            e += q;
            q++;
        }

        boolean g = e/1234 < e%1234;
        System.out.println(g);
    }
}
