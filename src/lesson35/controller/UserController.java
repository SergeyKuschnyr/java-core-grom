package lesson35.controller;

import lesson35.model.User;
import lesson35.service.UserService;

import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class UserController {
    UserService userService = new UserService();

    public User registerUser(User user) throws Exception{
        return userService.registerUser(user);
    }

    public void login(String userName, String password){

    }
    public void logout(){

    }
}
