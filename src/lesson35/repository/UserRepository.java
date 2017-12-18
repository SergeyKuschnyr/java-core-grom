package lesson35.repository;

import lesson35.model.User;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.io.File;


/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class UserRepository {
    //reading file
    //handling date - mapping date

    private File userFile;
    private File IDFile;

    public File getUserFile() {
        return userFile;
    }

    public File getIDFile() {
        return IDFile;
    }

    public void setUserFile(File userFile) {
        if (!userFile.exists())
            this.userFile = new File(userFile.getPath());
    }

    public void setIDFile(File IDFile) {
        if (IDFile.exists()) {
            return;
        }
        this.IDFile = new File(IDFile.getPath());
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(IDFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append("100");
        } catch (IOException e) {
            System.out.println("Can not create the file: " + IDFile.getPath());
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(fileWriter);
        }
    }

    public long registerUser(User user) throws InstanceAlreadyExistsException{
        if (!registrationValidate(user, userFile)) {
            throw new InstanceAlreadyExistsException("User with name " + user.getUserName() + " already existed");
        }
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(userFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(setUserID()).append(',');
            bufferedWriter.append(user.getUserName()).append(',');
            bufferedWriter.append(user.getPassword()).append(',');
            bufferedWriter.append(user.getCountry()).append("\n");
        } catch (IOException e) {
            System.out.println("Can not to file " + userFile.getPath());
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(fileWriter);
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

    private String setUserID() {
        String string = null;
        try {
            string = Long.toString(Long.parseLong(FileUtils.readFileToString(IDFile)) + 1);
            FileUtils.writeStringToFile(IDFile, string);
        } catch (IOException e) {
            System.out.println("Can not read from file or write to file " + IDFile);
        }
        return string;
    }

    private boolean registrationValidate(User user, File userFile) {
        if (userFile.length() == 0) {
            return true;
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(userFile);
            bufferedReader = new BufferedReader(fileReader);
            String userDB;
            while ((userDB = bufferedReader.readLine()) != null) {
                String[] userInfo = userDB.split(",");
                if (user.getUserName() == userInfo[1]) {
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("registrationValidate method: Can not read file " + userFile.getPath());
        } finally {
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(fileReader);
        }
        return true;
    }

    private boolean loginValidate(String userName, String password) throws Exception {
        FileReader fileReader = new FileReader(userFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String userDB;
        while ((userDB = bufferedReader.readLine()) != null) {
            String[] userInfo = userDB.split(",");
            if (userName == userInfo[1] && password == userInfo[2]) {
                return true;
            }
        }
        return false;
    }
}

