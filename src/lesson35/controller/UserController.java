package lesson35.controller;

import lesson35.model.User;
import lesson35.service.UserService;

import javax.management.InstanceAlreadyExistsException;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class UserController {
    UserService userService = new UserService();

    public long registerUser(User user) throws Exception{
        return userService.registerUser(user);
    }

    public UserService getUserService() {
        return userService;
    }

    public void login(String userName, String password)throws Exception{
        userService.login(userName, password);

    }
    public void logout() throws Exception{
        userService.logout();

    }
}
