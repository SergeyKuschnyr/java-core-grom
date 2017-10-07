package lesson30.itFirm;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kushn_000 on 01.10.2017.
 */
public class Firm {
    Date dateFoundation;
    ArrayList<Department> departments = new ArrayList();
    ArrayList<Customer> customers = new ArrayList();

    public Firm(Date dateFoundation, ArrayList<Department> departments, ArrayList<Customer> customers) {
        this.dateFoundation = dateFoundation;
        this.departments = departments;
        this.customers = customers;
    }
}

