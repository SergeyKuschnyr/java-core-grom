package lesson22.arrays.UserRepository;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 25.08.2017.
 */
public class Demo {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        User user1 = new User(1001L, "Daniil", "2545336kjhkj");
        UserRepository.save(user1);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user2 = new User(1002L, "Andrey", "poipopo5333636");
        UserRepository.save(user2);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user3 = new User(1001L, "Test", "2545336kjhkj");
        UserRepository.update(user3);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));
    }
}
