package lesson30.itFirm;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Kushn_000 on 02.10.2017.
 */
public class ProjectDAO {
    private HashSet<Project> projects;

    public ProjectDAO(HashSet<Project> projects) {
        this.projects = projects;
    }

    // список проектов, выполняемых для заданного заказчика
    public ArrayList projectsByCustomer(Customer customer){
        ArrayList<Project> tempPrj = new ArrayList<>();
        if (customer == null){
            return tempPrj;
        }
        for (Project project : projects){
            if (project.getCustomer().equals(customer)){
                tempPrj.add(project);
            }
        }
        return tempPrj;
    }
}
