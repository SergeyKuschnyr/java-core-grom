package lesson24.firstexample.exercise;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 25.08.2017.
 */
public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Sys> sysGeneralDAO = new GeneralDAO<>();
        Sys sys = new Sys(11, "....");
        sysGeneralDAO.save(sys);

        System.out.println(Arrays.deepToString(sysGeneralDAO.getAll()));

        sysGeneralDAO.save(sys);

        System.out.println(Arrays.deepToString(sysGeneralDAO.getAll()));

        GeneralDAO<Tool> toolGeneralDAO = new GeneralDAO<>();
        Tool tool = new Tool("aaaaa", "qqqqq");
        toolGeneralDAO.save(tool);

        System.out.println(Arrays.deepToString(toolGeneralDAO.getAll()));

        GeneralDAO<Order> orderGeneralDAO = new GeneralDAO<>();
    }
}
