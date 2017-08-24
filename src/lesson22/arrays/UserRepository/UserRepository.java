package lesson22.arrays.UserRepository;

/**
 * Created by Kushn_000 on 15.04.2017.
 */
public class UserRepository {
    private static User[] users;

    public UserRepository() {
        this.users = new User[10];
    }

    public static User[] getUsers() {
        return users;
    }

    public static User save(User user) {
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

    public static User update(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && user != null && users[i].getId() == user.getId()) {
                users[i] = new User(12345l, "Vyacheslav", "asdfgh");
                return user;
            }
        }
        return null;
    }

    public static void delete(long id) {
        for (int i = 0; i < users.length; i++)
            if (users[i] != null && users[i].getId() == id)
                users[i] = null;
    }

    private static User findById(long id) {
        for (int i = 0; i < users.length; i++)
            if (users[i] != null && users[i].getId() == id)
                return users[i];
        return null;
    }

    private static boolean findOfEmptyPlace(User[] inputUserArr) {
        for (User user : inputUserArr)
            if (user == null)
                return true;
        return false;
    }

    private static boolean findOfDuplicate(User inputUserArr) {
        for (User us : users)
            if (us != null)
                if (findById(us.getId()) == inputUserArr)
                    return true;
        return false;
    }

    public static void print(User[] userArr) {
        for (User us : userArr)
            if (us != null)
                System.out.println(us.getName());
    }
}
