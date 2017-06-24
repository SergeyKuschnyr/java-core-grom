package lesson14;

/**
 * Created by Kushn_000 on 24.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Object objectTest = new Object();

        if (objectTest != null) {
            System.out.println(objectTest.toString());
            if (objectTest.getClass() != null)
                System.out.println(objectTest.getClass().getName());
        }

        objectTest = new Object();

        if (objectTest != null) {
            System.out.println(objectTest.toString());
            if (objectTest.getClass() != null)
                System.out.println(objectTest.getClass().getName());
        }

        objectTest = new Object();

        if (objectTest != null) {
            System.out.println(objectTest.toString());
            if (objectTest.getClass() != null)
                System.out.println(objectTest.getClass().getName());
        }
    }
}
