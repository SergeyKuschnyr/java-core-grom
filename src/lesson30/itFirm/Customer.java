package lesson30.itFirm;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Customer {
    private String name;
    //private ArrayList<Project> projects;
    private String country;
    private int monthlyPay;

    public Customer(String name, String country, int monthlyPay) {
        this.name = name;
        this.country = country;
        this.monthlyPay = monthlyPay;
    }
}
