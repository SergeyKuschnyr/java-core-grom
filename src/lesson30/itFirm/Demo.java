package lesson30.itFirm;

import java.util.Date;
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
        TreeSet<Project> projects = new TreeSet<>();
        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);
        projects.add(project5);
        projects.add(project6);
        ProjectDAO projectDAO = new ProjectDAO(projects);

        TreeSet <Project> projects1 = new TreeSet<>();
        projects1.add(project1);
        projects1.add(project2);
        projects1.add(project4);
        TreeSet <Project> projects2 = new TreeSet<>();
        projects2.add(project3);
        projects2.add(project4);
        projects2.add(project1);
        TreeSet <Project> projects3 = new TreeSet<>();
        projects3.add(project5);
        projects3.add(project6);
        projects3.add(project2);

        Department department2 = new Department(DepartmentType.DEVELOPMENT_TYPE);
        Department department3 = new Department(DepartmentType.ANALYTICAL_TYPE);
        Department department4 = new Department(DepartmentType.DESIGNERS_TYPE);
        Department department5 = new Department(DepartmentType.FINANCIAL_TYPE);
        Department department6 = new Department(DepartmentType.MANAGMENT_TYPE);
        Department department7 = new Department(DepartmentType.OTHER);
        TreeSet<Department> departments = new TreeSet<>();
        departments.add(department2);
        departments.add(department3);
        departments.add(department4);
        departments.add(department5);
        departments.add(department6);
        departments.add(department7);
        DepartmentDAO departmentDAO = new DepartmentDAO(departments);

        Employee employee1 = new Employee("Oleg", "Kozlov", new Date(),
                Position.DEVELOPER, projects1);
        Employee employee2 = new Employee("Victor", "Sidorov", new Date(),
                Position.DEVELOPER, projects2);
        Employee employee3 = new Employee("Boris", "Egorov", new Date(),
                Position.DEVELOPER, projects3);
        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        EmployeeDAO employeeDAO = new EmployeeDAO(employees);

        Manager manager1 = new Manager("Collins", projects2);
        Manager manager2 = new Manager("Kshistoff", projects1);
        Manager manager3 = new Manager("Derevyanko", projects3);
        TreeSet<Manager> managers = new TreeSet<>();
        ManagerDAO managerDAO = new ManagerDAO(managers);

        Controller controller = new Controller(employeeDAO, managerDAO, projectDAO);
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("список сотрудников, работающих над заданным проектом");
        System.out.println(controller.employeesByProject(project1));
        System.out.println();

        employee1.setDepartment(new Department(DepartmentType.DEVELOPMENT_TYPE));
        employee2.setDepartment(new Department(DepartmentType.DEVELOPMENT_TYPE));
        employee3.setDepartment(new Department(DepartmentType.DEVELOPMENT_TYPE));

        System.out.println("список сотрудников из заданного отдела, не участвующих ни в одном проекте");
        System.out.println(controller.employeesByDepartmentWithoutProject(new Department(DepartmentType.DEVELOPMENT_TYPE)));
        System.out.println();

        System.out.println("список сотрудников, участвующих в проектах, выполняемых для заданного заказчика");
        System.out.println(controller.employeesByCustomerProjects(customer1));
        System.out.println();

        System.out.println("список сотрудников, участвующих в тех же проектах, что и заданный сотрудник");
        System.out.println(controller.employeesByProjectEmployee(employee3));
        System.out.println();

        System.out.println("список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)");
        System.out.println(controller.employeesByTeamLead(manager1));
        System.out.println();
        System.out.println("список проектов, в которых участвует заданный сотрудник");
        System.out.println(controller.projectsByEmployee(employee3));
        System.out.println();
////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("список сотрудников, не участвующих ни в одном проекте");
        System.out.println(controller.employeesWithoutProject());
        System.out.println();
///////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("список руководителей для заданного сотрудника");
        System.out.println(controller.teamLeadsByEmployee(employee3));
        System.out.println();

        System.out.println("список проектов, выполняемых для заданного заказчика");
        System.out.println(controller.projectsByCustomer(customer2));
        System.out.println();

//        - projectsByCustomer(Customer customer) - список проектов, выполняемых для заданного заказчика
    }
}
