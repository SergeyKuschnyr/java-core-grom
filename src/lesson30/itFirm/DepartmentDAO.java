package lesson30.itFirm;

import java.util.TreeSet;

/**
 * Created by Kushn_000 on 02.10.2017.
 */
public class DepartmentDAO {
    private TreeSet<Department> departments;

    public DepartmentDAO(TreeSet<Department> departments) {
        this.departments = departments;
    }

    public TreeSet Method(Department department){
        TreeSet<Employee> employees = new TreeSet<>();
        for (Department department1 : departments){
            //System.out.println("department1: " + department1 + "  " + "department: " + department);
            if (department1.equals(department)){
                for (Employee employee2 : department1.getEmployees()){
                    if (employee2.getProjects().size() == 0){
                        employees.add(employee2);
                    }
                }
            }
        }
        return employees;
    }
}
