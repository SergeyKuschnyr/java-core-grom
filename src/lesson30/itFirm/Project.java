package lesson30.itFirm;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Project {
    private String name;
    //private ArrayList<Employee> employees;
    //private Manager manager;
    private Customer customer;

    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }
}
