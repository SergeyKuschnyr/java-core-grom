package lesson30.itFirm;

import java.util.ArrayList;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Manager {
    private String name;
    private ArrayList<Project> projects;

    public Manager(String name, ArrayList<Project> projects) {
        this.name = name;
        this.projects = projects;
    }
}
