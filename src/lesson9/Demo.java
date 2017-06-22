package lesson9;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 16.04.2017.
 */
public class Demo {
    public static void main(String[] args) {

        User user1 = new User(123456l, "Nikolay", "qwerty1");
        User user2 = new User(1234567l, "Victoriya", "qwerty2");
        User user3 = new User(12345678l, "Vasiliy", "qwerty3");
        User user4 = new User(98765l, "Oqsana", "qwerty4");

        UserRepository userRepository = new UserRepository();

        userRepository.print(userRepository.getUsers());
        System.out.println();
        //////////save check////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        System.out.println("Added new users and return type check");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        userRepository.print(userRepository.getUsers());
        System.out.println();
/////////////////////////////////////////////////////////////////////////////////
        System.out.println("Added same user check");
        userRepository.save(user1);

        userRepository.print(userRepository.getUsers());
        System.out.println();
/////////////////////////////////////////////////////////////////////////////////
        System.out.println("Overfull check");
        for (int i = 0; i < 12; i++)
            userRepository.save(new User(user1.getId() + i, user1.getName(), user1.getSessionId()));

        userRepository.print(userRepository.getUsers());
        System.out.println();
//////////////////////////////////////////////////////////////////////////////////
        System.out.println("null save check");

        userRepository.delete(123456l);
        userRepository.save(null);

        userRepository.print(userRepository.getUsers());
        System.out.println();

        // update check///////////////////////////////////////////////////////////
        System.out.println("update method check");

        System.out. println("user is...");
        System.out.println(userRepository.update(user2).getName());
        System.out.println("--------------------------------");
        userRepository.print(userRepository.getUsers());
        System.out.println();

        System.out.println("user is'nt...");
        userRepository.update(user4);
        System.out.println("--------------------------------");
        userRepository.print(userRepository.getUsers());
        System.out.println();

        System.out.println("null check");
        userRepository.update(null);
        System.out.println("--------------------------------");
        userRepository.print(userRepository.getUsers());
        System.out.println();

        // delete method check//////////////////////////////////////////////////

        System.out.println("delete method check");
        System.out.println("--------------------------------");
        long id = userRepository.getUsers()[7].getId();
        userRepository.delete(id);
        userRepository.print(userRepository.getUsers());
        System.out.println();

        id = id + 21;
        userRepository.delete(id);
        userRepository.print(userRepository.getUsers());
        System.out.println();

    }
}

