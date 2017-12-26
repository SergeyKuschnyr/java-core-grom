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
public class UserRepository extends GeneralRepository{
    private File userDB;

    public File getUserDB() {
        return userDB;
    }

    public void setUserDB(File userDB) {
        if (!userDB.exists())
            this.userDB = new File(userDB.getPath());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public long registerUser(User user) throws InstanceAlreadyExistsException {
        if (!registrationValidate(user, userDB)) {
            throw new InstanceAlreadyExistsException("User with name " + user.getUserName() + " already existed");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userDB, true))) {
            bufferedWriter.append(setID()).append(',');
            bufferedWriter.append(user.getUserName()).append(',');
            bufferedWriter.append(user.getPassword()).append(',');
            bufferedWriter.append(user.getCountry()).append(',');
            bufferedWriter.append(user.getTYPE().toString()).append("\n");
        } catch (IOException e) {
            System.out.println("Can not write to file " + userDB.getPath());
        }
        return user.getId();
    }

    public void login(String userName, String password) throws Exception {
        //проверить есть ли юзер в базе по имени юзера и паролю
        //
        if (!loginValidate(userName, password)) {
            throw new Exception("Name or password is wrong");
        }

    }

    public void logout() {

    }

    private boolean registrationValidate(User user, File userFile) {
        if (user == null) {
            return false;
        }
        if (userFile == null || userFile.length() == 0) {
            return true;
        }
        for (User user1 : creatingUserInstance()){
            if (user1.equals(user)){
                return false;
            }
        }
        return true;
    }

    private boolean loginValidate(String userName, String password) {
        if (userName == null || password == null){
            return false;
        }
        for (User user : creatingUserInstance()){
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    private ArrayList<User> creatingUserInstance() {
        if (userDB == null || userDB.length() == 0){
            return new ArrayList();
        }
        ArrayList<User> usersAL = new ArrayList();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(userDB))){
            String string = "";
            while ((string = bufferedReader.readLine()) != null){
                String[] strings = string.split(",");
                User user = new User(strings[1], strings[2], strings[3], UserType.valueOf(strings[4]));
                usersAL.add(user);
            }
        }catch (IOException e){
            System.out.println("Can't read to file:" + userDB.getPath());
        }
        return usersAL;
    }
}

