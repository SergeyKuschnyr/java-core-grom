package lesson24.firstexample;

/**
 * Created by Kushn_000 on 25.08.2017.
 */
public class Demo <T>{
    private static void calculate(AbstractOrder abstractOrder){
        System.out.println(abstractOrder.getPrice());
    }

    public void print(T t){
        System.out.println(t);
    }

//    private static void calculate(SecondOrder secondOrder){
//        Sys.out.println(secondOrder.getPrice());
//    }

    public static void main(String[] args) {
        calculate(new FirstOrder());
        calculate(new SecondOrder());
    }
}
