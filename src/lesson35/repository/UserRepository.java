package lesson35.repository;

import lesson35.model.User;
import lesson35.model.UserType;
import org.apache.commons.io.FileUtils;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class UserRepository extends GeneralRepository {
    private String path = "C:/Lesson35_DBFile/userDB.txt";

    public String getPath() {
        return path;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public long registerUser(User user) throws Exception {
        if (!registrationValidate(user)) {
            throw new InstanceAlreadyExistsException("User with name " + user.getUserName() + " already existed");
        }
        addUser(user);
        return user.getId();
    }

    public void login(String userName, String password) throws Exception {
        if (loginValidate(userName, password) == null) {
            throw new Exception("Name or password is wrong");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), true))) {
            String string = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings[1].equals(userName) && strings[2].equals(password)) {
                    string += ",*";
                }
                stringBuilder.append(string).append("\n");
            }
            FileUtils.write(new File(path), "");
            bufferedWriter.append(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("Can't to handle file: " + path);
        }
    }

    public void logout() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), true))) {
            String string = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings.length == 6) {
                    string = string.replace(",*", "");
                }
                stringBuilder.append(string).append("\n");
            }
            FileUtils.write(new File(path), "");
            bufferedWriter.append(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("Can't handled file: " + path);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<User> mapping(ArrayList<String> strings) {
        if (strings == null) {
            return new ArrayList();
        }
        ArrayList instancesAL = new ArrayList();

        for (String string : strings) {
            String[] str = string.split(",");
            User user = new User(str[1], str[2], str[3], UserType.valueOf(str[4]));//////////
            user.setId(Long.parseLong(str[0]));///////////////////////////////////////////////////////////
            instancesAL.add(user);
        }
        return instancesAL;
    }

    private boolean registrationValidate(User user) throws Exception {
        if (user == null || new File(path) == null) {
            throw new Exception("Input date is error");
        }
        if ((new File(path)).length() == 0) {
            return true;
        }
        for (int i = 0; i < mapping(readFile(new File(path))).size(); i++) {
            if (user.equals(mapping(readFile(new File(path))).get(i))) {
                return false;
            }
        }
        return true;
    }

    private User loginValidate(String userName, String password) throws Exception {
        if (userName == null || password == null) {
            return null;
        }
        ArrayList<User> arrayList = mapping(readFile(new File(path)));
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getUserName().equals(userName) &&
                    arrayList.get(i).getPassword().equals(password)) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    public void addUser(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), true))) {
            bufferedWriter.append(setID()).append(',');
            bufferedWriter.append(user.getUserName()).append(',');
            bufferedWriter.append(user.getPassword()).append(',');
            bufferedWriter.append(user.getCountry()).append(',');
            bufferedWriter.append(user.getTYPE().toString()).append("\n");
        } catch (IOException e) {
            System.out.println("Can not write to file " + (new File(path)).getPath());
        }
    }

//    @Override
//    public void instanceDBUpdate(String[] strings, ArrayList itemAL) {
//        User user = new User(strings[1], strings[2], strings[3], UserType.valueOf(strings[4]));//////////
//        user.setId(Long.parseLong(strings[0]));///////////////////////////////////////////////////////////
//        itemAL.add(user);
//    }

//    public void login(String userName, String password) throws Exception {
//        User user2 = loginValidate(userName, password);
//        if (user2 == null) {
//            throw new Exception("Name or password is wrong");
//        }
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(loginUserDB, true))) {
//            bufferedWriter.append(Long.toString(user2.getId())).append(',');
//            bufferedWriter.append(user2.getUserName()).append(',');
//            bufferedWriter.append(user2.getPassword()).append(',');
//            bufferedWriter.append(user2.getCountry()).append(',');
//            bufferedWriter.append(user2.getTYPE().toString()).append("\n");
//        } catch (Exception e) {
//            System.out.println("Can't write to the file" + loginUserDB.getPath());
//        }
//    }

//    public void logout() throws Exception {
//        FileUtils.write(new File(loginUserDB.getPath()), "");
//    }
}


