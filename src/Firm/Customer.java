package Firm;

import java.util.ArrayList;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Customer {
    private String name;
    private ArrayList<Project> projects;

    public Customer(String name, ArrayList<Project> projects) {
        this.name = name;
        this.projects = projects;
    }
}
