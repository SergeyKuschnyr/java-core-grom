package lesson30.itFirm;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Project implements Comparable<Project>{
    private String name;
    private Customer customer;

    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!name.equals(project.name)) return false;
        return customer.equals(project.customer);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + customer.hashCode();
        return result;
    }

    @Override
    public int compareTo(Project prjt) {
        return this.getName().compareTo(prjt.getName());
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                '}';
    }
}
