package lesson4;

/**
 * Created by Kushn_000 on 12.03.2017.
 */
public class DivCount {
    public static void main(String[] args) {
        System.out.println(findDivCount((short) 12, (short) 89, 4));
    }

    public static int findDivCount(short a, short b, int n){
        int res = 0;
        for (int i = a; i <= b; i++){
            if(i%n == 0)
                res++;
        }
        return res;
    }
}
