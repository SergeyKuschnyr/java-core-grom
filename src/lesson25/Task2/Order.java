package lesson25.Task2;

/**
 * Created by Kushn_000 on 27.08.2017.
 */
public class Order {
    private long id;
    private String city;
    private long amount;

    public Order(long id, String city, long amount) {
        this.id = id;
        this.city = city;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", amount=" + amount +
                '}';
    }
}
