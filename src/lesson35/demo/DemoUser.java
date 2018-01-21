package lesson35.demo;

import lesson35.controller.UserController;
import lesson35.model.User;
import lesson35.model.UserType;
import lesson35.repository.UserRepository;

import javax.management.InstanceAlreadyExistsException;
import java.io.File;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class DemoUser {
    public static void main(String[] args) {

        UserController userController = new UserController();
        (new UserRepository()).setUserDB(new File((new UserRepository()).getPath().toString()));

        User user1 = new User("John", "pass111", "USA", UserType.USER_TYPE);
        User user2 = new User("Bill", "pass222", "USA", UserType.USER_TYPE);
        User user3 = new User("Andrey", "pass333", "Ukraine", UserType.USER_TYPE);
        User user4 = new User("Sara", "pass444", "UK", UserType.ADMIN_TYPE);


        try {
            userController.registerUser(user1);
            userController.registerUser(user2);
            userController.registerUser(user3);
            userController.registerUser(user4);

            userController.login("Sara", "pass444");
//            UserRepository.printUser();
            //userController.logout();
//            UserRepository.printUser();

        }catch (Exception e){
            System.out.println("DemoUser: " + e.getMessage());
        }

    }
}






