package lesson27.userRepository;

import java.util.ArrayList;

/**
 * Created by Kushn_000 on 15.04.2017.
 */
public class UserRepository {
    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    //////////////////////////////////////////////////////////
    public User save(User user) {
        if (user == null)
            return null;
        if (findOfDuplicate(user))
            return null;
        users.add(user);
        return users.get(users.size() - 1);
    }

    public User update(User user) {
        if (user == null)
            return null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, new User(12345l, "Vyacheslav", "asdfgh"));
                return user;
            }
        }
        return null;
    }

    public void delete(long id) {
        if (id == 0)
            return;
        for (int i = 0; i < users.size(); i++)
            if (users.get(i).getId() == id)
                users.remove(i);
    }

    public User findById(long id) {
        for (int i = 0; i < users.size(); i++)
            if (users.get(i).getId() == id)
                return users.get(i);
        return null;
    }

    private boolean findOfDuplicate(User inputUserArr) {
        for (User us : users)
            if (us.getId() == inputUserArr.getId())
                return true;
        return false;
    }

    public void print(ArrayList<User> users) {
        if (users == null) {
            System.out.println("Sorry. \"Users\" is Null");
            return;
        }
        for (User us : users)
            if (us != null)
                System.out.println(us.toString());
    }
}
