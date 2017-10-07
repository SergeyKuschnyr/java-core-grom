package lesson30.itFirm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Billy", "USA", 30000);
        Customer customer2 = new Customer("Gerry", "USA", 30000);
        Customer customer3 = new Customer("Rayan", "Australia", 30000);
        Customer customer4 = new Customer("Billy", "GB", 30000);
        Customer customer5 = new Customer("Scott", "USA", 30000);
        Customer customer6 = new Customer("Fill", "Germany", 30000);

        Project project1 = new Project("Toy Shop", customer1);
        Project project2 = new Project("Fish Shop", customer2);
        Project project3 = new Project("Search System", customer3);
        Project project4 = new Project("Pay System", customer4);
        Project project5 = new Project("Auto Shop", customer5);
        Project project6 = new Project("Real Adviser", customer6);

        TreeSet <Project> projects1 = new TreeSet<>();
        projects1.add(project1);
        projects1.add(project2);
        projects1.add(project4);
        TreeSet <Project> projects2 = new TreeSet<>();
        projects2.add(project3);
        projects2.add(project4);
        projects2.add(project1);
        TreeSet <Project> projects3 = new TreeSet<>();
//        projects3.add(project5);
//        projects3.add(project6);
//        projects3.add(project2);

        System.out.println(projects3);  ///////////

        Employee employee1 = new Employee("Oleg", "Kozlov", new Date(),
                Position.DEVELOPER, projects1);
        employee1.setDepartment(new Department(DepartmentType.DEVELOPMENT_TYPE));
        Employee employee2 = new Employee("Victor", "Sidorov", new Date(),
                Position.DEVELOPER, projects2);
        employee2.setDepartment(new Department(DepartmentType.DEVELOPMENT_TYPE));
        Employee employee3 = new Employee("Boris", "Egorov", new Date(),
                Position.DEVELOPER, projects3);
        employee3.setDepartment(new Department(DepartmentType.DEVELOPMENT_TYPE));

//        System.out.println(employee3);  //////////
        System.out.println();           //////////

        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

//        System.out.println(employees);  ///////////
        System.out.println();           //////////

        EmployeeDAO employeeDAO = new EmployeeDAO(employees);
        Controller controller = new Controller(employeeDAO);

        System.out.println("список сотрудников, работающих над заданным проектом");
        System.out.println(controller.
                employeesByProject
                        (project1));
        System.out.println();

        Department department = new Department(DepartmentType.DEVELOPMENT_TYPE);
        department.setEmployees(employees);

        System.out.println("список сотрудников из заданного отдела, не участвующих ни в одном проекте");
        System.out.println(controller.employeesByDepartmentWithoutProject(department));
//
//        Employee employee1 = new Employee("John", "McDonalds", new Date(2012, 5, 12),
//                Position.DEVELOPER, projects);
//        Employee employee2 = new Employee("Egor", "Ivanov", new Date(2012, 5, 12),
//                Position.DEVELOPER, projects);
//        Employee employee3 = new Employee("Yan", "Gillan", new Date(2012, 5, 12),
//                Position.DEVELOPER, projects);
//
//        HashSet<Employee> employees = new HashSet<>();
//        employees.add(employee1);
//        employees.add(employee2);
//        employees.add(employee3);
//
//        EmployeeDAO employeeDAO = new EmployeeDAO(employees);
////        employeeDAO.getEmployees().add(employee1);
////        employeeDAO.getEmployees().add(employee2);
////        employeeDAO.getEmployees().add(employee3);
//
//
//
//
//        //Controller controller = new Controller();
//        System.out.println(employeeDAO.employeesByProject(project1));
    }
}
