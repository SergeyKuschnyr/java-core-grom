package lesson3;

/**
 * Created by Kushn_000 on 10.03.2017.
 */
public class BitwiseOperators {
    public static void main(String[] args) {
        int a =60;
        int b = 13;
        int c = 0;

        c = a & b;  /* 12 = 0000 1100 */
        System.out.println("a & b = " + c);

        c = a | b;  /* 61 = 0011 1101 */
        System.out.println("a | b = " + c);

        c = a ^ b;  /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c);

        c = a << 2; /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c);

        c = a >> 2; /* 15 = 1111 */
        System.out.println("a >> 2  = " + c);
    }
}
