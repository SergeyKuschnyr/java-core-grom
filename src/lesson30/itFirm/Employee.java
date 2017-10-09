package lesson30.itFirm;

import java.util.Date;
import java.util.TreeSet;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private TreeSet<Project> projects;

    public Employee(String firstName, String lastName, Date dateHired, Position position,
                    TreeSet<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.projects = projects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public TreeSet<Project> getProjects() {
        return projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!firstName.equals(employee.firstName)) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!dateHired.equals(employee.dateHired)) return false;
        if (position != employee.position) return false;
        if (!department.equals(employee.department)) return false;
        return projects.equals(employee.projects);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + dateHired.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + projects.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                ", projects=" + projects +
                '}' + "\n";
    }

    @Override
    public int compareTo(Employee empl) {
        if (!this.firstName.equals(empl.firstName)) {
            return this.firstName.compareTo(empl.firstName);
        }
        if (!this.lastName.equals(empl.lastName)) {
            return this.lastName.compareTo(empl.lastName);
        }
        return 0;
    }
}
