package Firm;

import java.util.ArrayList;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Project {
    private String name;
    private ArrayList<Employee> employees;
    private Manager manager;
    private Customer customer;

    public Project(String name, Manager manager, Customer customer) {
        this.name = name;
        this.manager = manager;
        this.customer = customer;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
