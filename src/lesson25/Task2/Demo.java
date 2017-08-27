package lesson25.Task2;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 27.08.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        Order order = new Order(1234L, "dnepr", 40L);
        Order order2 = new Order(1235L, "kiev", 50L);

        Car car = new Car(90, 200, "Diesel");
        Car car2 = new Car(60, 160, "Gas");


        GeneralDAO<Order> generalDAO = new GeneralDAO<>();
        generalDAO.save(order);
        generalDAO.save(order2);
        System.out.println(Arrays.deepToString(generalDAO.getArrT()));
        System.out.println();
        System.out.println(Arrays.deepToString(generalDAO.getAll(generalDAO.getArrT())));

        System.out.println();

        GeneralDAO<Car> generalDAO2 = new GeneralDAO<>();
        generalDAO2.save(car);
        generalDAO2.save(car2);
        System.out.println(Arrays.deepToString(generalDAO2.getArrT()));
        System.out.println();
        System.out.println(Arrays.deepToString(generalDAO2.getAll(generalDAO2.getArrT())));

    }
}
