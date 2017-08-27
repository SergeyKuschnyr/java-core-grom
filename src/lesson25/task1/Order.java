package lesson25.task1;

/**
 * Created by Kushn_000 on 27.08.2017.
 */
public class Order extends IdEntity {
    private long id;

    public Order(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }

    //    public Order(long id) {
//        this.id = id;
//    }
}
