package lesson8;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Kushn_000 on 08.04.2017.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(createHighestParent().firstName + " " + createHighestParent().lastName + " " +
                createHighestParent().group + " " + Arrays.toString(createHighestParent().coursesTaken));
        System.out.println(createLowestChild().firstName + " " + createLowestChild().lastName + " " +
                createLowestChild().group + " " + createLowestChild().coursesTaken + " " +
                createLowestChild().secretKey + " " + createLowestChild().email);
    }

    static Student createHighestParent() {

        Course course1 = new Course(new Date(20170305), "Arithmetic", 45, "Petrov",
                new Student[21]);
        Course course2 = new Course(new Date(20170307), "Phisics", 44, "Kozlov",
                new Student[21]);
        Course course3 = new Course(new Date(20170312), "Economic", 34, "Ivolgin",
                new Student[21]);

        Course[] courseArr = {course1, course2, course3};

        Student student = new Student("Sergey", "Ivanov", 8, courseArr);

        return student;
    }

    static SpecialStudent createLowestChild() {
        SpecialStudent sStudent = new SpecialStudent("Igor", "Petrov", 3, new Course[21],
                12345667, "Igor.Petrov@hotmale.com");
        return sStudent;
    }
}
