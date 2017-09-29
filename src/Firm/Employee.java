package Firm;

import java.util.ArrayList;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Employee {
    private String name;
    private Department department;
    private ArrayList<Project> projects;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
