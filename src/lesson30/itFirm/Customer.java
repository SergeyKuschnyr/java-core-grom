package lesson30.itFirm;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Customer implements Comparable<Customer>{
    private String name;
    private String country;
    private int monthlyPay;

    public Customer(String name, String country, int monthlyPay) {
        this.name = name;
        this.country = country;
        this.monthlyPay = monthlyPay;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Customer cstm){
        return this.getName().compareTo(cstm.getName());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", monthlyPay=" + monthlyPay +
                '}' + "\n";
    }
}
