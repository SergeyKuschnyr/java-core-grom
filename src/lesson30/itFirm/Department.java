package lesson30.itFirm;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Department {
    private DepartmentType type;
    private HashSet<Employee> employees;

    public Department(DepartmentType type, HashSet<Employee> employees) {
        this.type = type;
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (type != that.type) return false;
        return employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + employees.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", employees=" + employees +
                '}';
    }
}
