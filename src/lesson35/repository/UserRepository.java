package lesson35.repository;

import lesson35.model.User;
import lesson35.model.UserType;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.io.File;
import java.util.ArrayList;


/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class UserRepository extends GeneralRepository {
    private static File userDB;
    private static User user;

    public static File getUserDB() {
        return userDB;
    }

    public static User getUser() {
        return user;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public long registerUser(User user) throws InstanceAlreadyExistsException {
        if (!registrationValidate(user, userDB)) {
            throw new InstanceAlreadyExistsException("User with name " + user.getUserName() + " already existed");
        }
        userDBUpdate(user);
        return user.getId();
    }

    public void login(String userName, String password) throws Exception {
        User user2 = loginValidate(userName, password);
        if (user2 == null) {
            throw new Exception("Name or password is wrong");
        }
        user = user2;
    }

    public void logout() {
        user = null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean registrationValidate(User user, File userFile) {
        if (user == null) {
            return false;
        }
        if (userFile == null || userFile.length() == 0) {
            return true;
        }
        for (User user1 : userInstanceDB()) {
            if (user1.equals(user)) {
                return false;
            }
        }
        return true;
    }

    private User loginValidate(String userName, String password) {
        if (userName == null || password == null) {
            return null;
        }
        for (User user : userInstanceDB()) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private ArrayList<User> userInstanceDB() {
        if (userDB == null || userDB.length() == 0) {
            return new ArrayList();
        }
        ArrayList<User> usersAL = new ArrayList();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(userDB))) {
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                User user = new User(strings[1], strings[2], strings[3], UserType.valueOf(strings[4]));
                usersAL.add(user);
            }
        } catch (IOException e) {
            System.out.println("Can't read to file:" + userDB.getPath());
        }
        return usersAL;
    }

    private void userDBUpdate(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userDB, true))) {
            bufferedWriter.append(setID()).append(',');
            bufferedWriter.append(user.getUserName()).append(',');
            bufferedWriter.append(user.getPassword()).append(',');
            bufferedWriter.append(user.getCountry()).append(',');
            bufferedWriter.append(user.getTYPE().toString()).append("\n");
        } catch (IOException e) {
            System.out.println("Can not write to file " + userDB.getPath());
        }
    }
}

