package lesson35.demo;

import lesson35.controller.UserController;
import lesson35.model.User;
import lesson35.model.UserType;

import javax.management.InstanceAlreadyExistsException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class DemoUser {
    public static void main(String[] args) {
        File userFile = new File("C:/Lesson35_DBFile/userFile.txt");
        File IDFile = new File("C:/Lesson35_DBFile/IDFile.txt");

        UserController userController = new UserController();
        userController.getUserService().getUserRepository().setUserFile(userFile);
        userController.getUserService().getUserRepository().setIDFile(IDFile);

        User user1 = new User("John", "pass111", "USA", UserType.USER_TYPE);
        User user2 = new User("Bill", "pass222", "USA", UserType.USER_TYPE);
        User user3 = new User("Andrey", "pass333", "Ukraine", UserType.USER_TYPE);

        try {
            userController.registerUser(user1);
            userController.registerUser(user2);
            userController.registerUser(user3);
        }catch (InstanceAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
    }
}
