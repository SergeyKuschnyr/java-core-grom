package lesson15.HW.userRepository;

/**
 * Created by Kushn_000 on 16.04.2017.
 */
public class Demo {
    public static void main(String[] args) {

        User user1 = new User(123456l, "Nikolay", "qwerty1");
        User user2 = new User(1234567l, "Victoriya", "qwerty2");
        User user3 = new User(12345678l, "Vasiliy", "qwerty3");
        User user4 = new User(98765l, "Oqsana", "qwerty4");
        User user5 = new User(1234567l, "Nikifor", "qwerty5");

        UserRepository userRepository = new UserRepository();

        if (userRepository != null) {

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
                if (user1 != null)
                    userRepository.save(new User(user1.getId() + i, user1.getName(), user1.getSessionId()));

            userRepository.print(userRepository.getUsers());
            System.out.println();
//////////////////////////////////////////////////////////////////////////////////
            System.out.println("null save check");

//        userRepository.delete(user3);
            userRepository.save(null);

            userRepository.print(userRepository.getUsers());
            System.out.println();

            // update check///////////////////////////////////////////////////////////
            System.out.println("update method check");
            System.out.println("--------------------------------");

            System.out.println("user is...");
            userRepository.update(user5);
            userRepository.print(userRepository.getUsers());

            System.out.println();

            System.out.println("user is'nt...");
            userRepository.update(user4);
            userRepository.print(userRepository.getUsers());
            System.out.println();

            System.out.println("null check");
            userRepository.update(null);
            userRepository.print(userRepository.getUsers());
            System.out.println();

            // delete method check//////////////////////////////////////////////////
            System.out.println("delete method check");
            System.out.println("--------------------------------");
            userRepository.delete(user3);
            userRepository.print(userRepository.getUsers());
            System.out.println();

            userRepository.delete(user3);
            userRepository.print(userRepository.getUsers());
            System.out.println();
        }

    }
}

