package lesson15.HW.userRepository;

/**
 * Created by Kushn_000 on 15.04.2017.
 */
public class UserRepository {
    private User[] users;

    public UserRepository() {
        this.users = new User[10];
    }

    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
        if (!findOfEmptyPlace(users))
            return null;
        if (findOfDuplicate(user))
            return null;

        for (int i = 0; i < users.length; i++)
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        return user;
    }

    public User update(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && user != null && users[i].equals(user)) {
                users[i] = new User(12345l, "Vyacheslav", "asdfgh");
                return users[i];
            }
        }
        return null;
    }

    public void delete(User user) {
        for (int i = 0; i < users.length; i++)
            if (users[i] != null && users[i].equals(user))
                users[i] = null;
    }

    private User findById(User user) {
        for (int i = 0; i < users.length; i++)
            if (users[i] != null && users[i].equals(user))
                return users[i];
        return null;
    }

    private boolean findOfEmptyPlace(User[] inputUserArr) {
        for (User user : inputUserArr)
            if (user == null)
                return true;
        return false;
    }

    private boolean findOfDuplicate(User inputUser) {
        for (User us : users)
            if (us != null && us.equals(inputUser))
                return true;
        return false;
    }

    public void print(User[] userArr) {
        for (User us : userArr)
            // if (us != null)
            System.out.println(us);
    }
}
