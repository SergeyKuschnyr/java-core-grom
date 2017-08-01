package lesson19;

/**
 * Created by Kushn_000 on 29.07.2017.
 */
public class ThrowExample {
    private static String[] array = {"test", "test1", "tesqwd", null, "adsasf", "sdfsdf"};

    public static void main(String[] args) {
        useOfTestMethod();
    }

    private static void test() throws Exception{
        for (String element : array){
            if (element == null)
                throw new Exception("null is detected");
        }

        System.out.println("done");
    }

    private static void useOfTestMethod(){
        try {
            test();
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }
}
