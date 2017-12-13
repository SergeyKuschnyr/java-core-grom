package lesson35.service;

import lesson35.model.User;
import lesson35.repository.UserRepository;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class UserService {
        UserRepository userRepository = new UserRepository();

    public User registerUser(User user) throws Exception {
        //check business logic
        //if logic ok
        return userRepository.registerUser(user);
    }
}
