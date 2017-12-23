package lesson35.repository;

import lesson35.model.User;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;


/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class UserRepository {
    private File userFile;
    private Set<Long> IDCollection = new HashSet<>();

    public File getUserFile() {
        return userFile;
    }

    public void setUserFile(File userFile) {
        if (!userFile.exists())
            this.userFile = new File(userFile.getPath());
    }

    public long registerUser(User user) throws InstanceAlreadyExistsException {
        if (!registrationValidate(user, userFile)) {
            throw new InstanceAlreadyExistsException("User with name " + user.getUserName() + " already existed");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userFile, true))) {
            bufferedWriter.append(IDSetup()).append(',');
            bufferedWriter.append(user.getUserName()).append(',');
            bufferedWriter.append(user.getPassword()).append(',');
            bufferedWriter.append(user.getCountry()).append("\n");
        } catch (IOException e) {
            System.out.println("Can not to file " + userFile.getPath());
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

    private String IDSetup() {
        while (true) {
            long value = Long.valueOf(new Random().nextInt(1000));
            if (IDCollection.add(value)) {
                return Long.toString(value);
            }
        }
    }

    private boolean registrationValidate(User user, File userFile) {
        if (user == null) {
            return false;
        }
        if (userFile == null || userFile.length() == 0) {
            return true;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(userFile))) {
            String userDB;
            while ((userDB = bufferedReader.readLine()) != null) {
                String[] userInfo = userDB.split(",");
                if (user.getUserName().equals(userInfo[1]) && user.getTYPE().toString().equals(userInfo[4])) {
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("registrationValidate method: Can not read file " + userFile.getPath());
        }
        return true;
    }

    private boolean loginValidate(String userName, String password) throws Exception {
        FileReader fileReader = new FileReader(userFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String userDB;
        while ((userDB = bufferedReader.readLine()) != null) {
            String[] userInfo = userDB.split(",");
            if (userName.equals(userInfo[1]) && password.equals(userInfo[2])) {
                return true;
            }
        }
        return false;
    }
}

