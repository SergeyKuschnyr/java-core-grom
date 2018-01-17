package lesson35.service;

import lesson35.model.User;
import lesson35.repository.UserRepository;

import javax.management.InstanceAlreadyExistsException;
import java.io.File;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class UserService {
    UserRepository userRepository = new UserRepository();

    public long registerUser(User user) throws Exception{
        return userRepository.registerUser(user);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void login (String userName, String password)throws Exception{
        userRepository.login(userName, password);
    }

    public void logout() throws Exception{
        userRepository.logout();
    }
}
