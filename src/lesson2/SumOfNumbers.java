package lesson2;

/**
 * Created by Kushn_000 on 08.03.2017.
 */
public class SumOfNumbers {
    public static void main(String[] args) {
        int q = 0;
        int w = 10000000;
        long e = 0;
        while (q <= w){
            e += q;
            q++;
        }
        System.out.println(e);
    }
}
