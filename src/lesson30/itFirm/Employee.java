package lesson30.itFirm;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private ArrayList<Project> projects;

    public Employee(String name, Department department) {
        this.firstName = name;
        this.department = department;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
