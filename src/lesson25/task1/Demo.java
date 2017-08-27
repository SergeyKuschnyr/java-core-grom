package lesson25.task1;

/**
 * Created by Kushn_000 on 27.08.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        GeneralDAO generalDAO = new GeneralDAO();
        Order order = new Order(-1);

        //generalDAO.validate(order);

        TestClass <String, Order, Long> testClass = new TestClass<>();
        System.out.println(testClass.doSomething1("rrr"));
        System.out.println(testClass.doSomething2(order));

        TestClass <Integer, Boolean, String> testClass1 = new TestClass<>();
        System.out.println(testClass1.doSomething1(9));
        System.out.println(testClass1.doSomething2(true));

        int test = 100;
        long variable = 111;
        Long variable2 = new Long(222);

        generalDAO.validate(variable2);
        generalDAO.validate(test);
    }
}
