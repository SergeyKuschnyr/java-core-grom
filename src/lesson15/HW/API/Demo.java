package lesson15.HW.API;

import java.util.Date;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class Demo {
    public static void main(String[] args) {

        Room[] tempRoom1 = {
                new Room(123456, 20, 2, new Date(20170515), "Украина", "Киев"),
                new Room(126543, 30, 3, new Date(20170510), "Европейская", "Киев"),
                new Room(122362, 40, 4, new Date(20170503), "Харьков", "Харьков"),
                new Room(121625, 30, 2, new Date(20170521), "Днепропетровск", "Днепр"),
                new Room(127654, 70, 3, new Date(20170601), "Дерибас", "Одесса")
        };

        Room[] tempRoom2 = {
                new Room(123459, 20, 2, new Date(20170515), "Украина", "Киев"),
                new Room(126547, 10, 2, new Date(20170510), "Славутич", "Киев"),
                new Room(122368, 50, 3, new Date(20170503), "Сумская", "Харьков"),
                new Room(121625, 20, 3, new Date(20170521), "Днепропетровск", "Днепр"),
                new Room(127650, 40, 3, new Date(20170601), "Одесса", "Одесса")
        };

        Room[] tempRoom3 = {
                new Room(123451, 20, 4, new Date(20170515), "Львовская", "Львов"),
                new Room(126543, 30, 3, new Date(20170510), "Европейская", "Киев"),
                new Room(122361, 60, 2, new Date(20170503), "Камьянець",
                        "Каменец-Подольский"),
                new Room(121621, 20, 2, new Date(20170521), "Полесье", "Чернигов"),
                new Room(127651, 70, 1, new Date(20170601), "София", "Житомир")
        };

        API[] apis = {new GoogleAPI(tempRoom1), new TripAdvisorAPI(tempRoom2), new BookingComAPI(tempRoom3)};

        Controller controller = new Controller(apis);

        controller.print(controller.requestRooms(70, 1, "София", "Житомир"));
        System.out.println();

        controller.print(controller.requestRooms(70, 3, "Дерибас", "Одесса"));

        System.out.println();

        controller.print(controller.check(apis[0], apis[1]));

        System.out.println();

        controller.print(controller.requestRooms(0, 0, null, null));

    }
}
