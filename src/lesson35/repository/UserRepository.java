package lesson35.repository;

import lesson35.model.User;
import lesson35.model.UserType;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class UserRepository {
    //reading file
    //handling date - mapping date

    private File userFile;
    private File IDFile;

    public UserRepository(File userFile, File IDFile) throws IOException{
        if (!userFile.exists())
            this.userFile = new File(userFile.getPath());
        if (!IDFile.exists()) {
            this.IDFile = new File(IDFile.getPath());
            FileWriter fileWriter = new FileWriter(IDFile);
            fileWriter.append("100");
        }
    }

    public User registerUser(User user) throws Exception{
        regUserValidate(user, userFile);

        FileWriter fileWriter = new FileWriter(userFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(setUserID()).append(',');
        bufferedWriter.append(user.getUserName()).append(',');
        bufferedWriter.append(user.getPassword()).append(',');
        bufferedWriter.append(user.getCountry()).append("\n");
        return user;
    }

    public void login(String userName, String password)throws Exception{
        //проверить есть ли юзер в базе по имени юзера и паролю
        //
        if (!loginValidate(userName,password)){
            throw new Exception("Name or password is wrong");
        }

    }
    public void logout(){

    }

    private CharSequence setUserID() throws Exception{
        String string = Long.toString(Long.parseLong(FileUtils.readFileToString(IDFile)) + 1);
        FileUtils.writeStringToFile(IDFile, string);
        return string;
    }

    private void regUserValidate(User user, File userFile) throws Exception{
        FileReader fileReader = new FileReader(userFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String userDB;
        while ((userDB = bufferedReader.readLine()) != null){
            String[] userInfo = userDB.split(",");
            if (user.getUserName() == userInfo[1]){
                throw new Exception("Error: User with name " + user.getUserName() + " already existed");
            }
        }
        while ((userDB = bufferedReader.readLine()) != null){
            String[] userInfo = userDB.split(",");
            if (user.getPassword() != userInfo[2]){
                throw new Exception("Error: Password" + user.getPassword() + " already existed. Choice other");
            }
        }
    }

    private boolean loginValidate(String userName, String password) throws Exception{
        FileReader fileReader = new FileReader(userFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String userDB;
        while ((userDB = bufferedReader.readLine()) != null){
            String[] userInfo = userDB.split(",");
            if (userName == userInfo[1] && password == userInfo[2]){
                return true;
            }
        }
        return false;
    }

//    public ArrayList readUsersDB() throws IOException{
//        return new ArrayList(Arrays.asList(FileUtils.readFileToString(userFile).split("\\n")));
//    }
}

