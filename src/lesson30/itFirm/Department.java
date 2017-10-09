package lesson30.itFirm;

import java.util.TreeSet;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Department implements Comparable<Department> {
    private DepartmentType type;
    private TreeSet<Employee> employees;

    public Department(DepartmentType type) {
        this.type = type;
    }

    public TreeSet<Employee> getEmployees() {
        return employees;
    }

    @Override
    public int compareTo(Department dept) {
        return this.type.compareTo(dept.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return type == that.type;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", employees=" + employees +
                '}';
    }
}
