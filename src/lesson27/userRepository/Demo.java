package lesson27.userRepository;

import java.util.ArrayList;

/**
 * Created by Kushn_000 on 16.04.2017.
 */
public class Demo {
    public static void main(String[] args) {

        User user1 = new User(123456l, "Nikolay", "qwerty1");
        User user2 = new User(1234567l, "Victoriya", "qwerty2");
        User user3 = new User(12345678l, "Vasiliy", "qwerty3");
        User user4 = new User(98765l, "Oqsana", "qwerty4");

        ArrayList<User> arrayList = new ArrayList<>();

        UserRepository userRepository = new UserRepository(arrayList);
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
////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Added null-user");
        userRepository.save(null);

        userRepository.print(userRepository.getUsers());
        System.out.println();

        // update check///////////////////////////////////////////////////////////
        System.out.println("update method check");

        System.out. println("user exist");
        System.out.println(userRepository.update(user2));
        System.out.println("--------------------------------");
        userRepository.print(userRepository.getUsers());
        System.out.println();

        System.out.println("user don't exist");
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
        userRepository.delete(123456l);
        userRepository.print(userRepository.getUsers());
        System.out.println();

        userRepository.delete(123);
        userRepository.print(userRepository.getUsers());
        System.out.println();

        userRepository.save(user4);

        // findById check
        System.out.println(userRepository.findById(12345678));
        System.out.println(userRepository.findById(0));


    }
}

