package lesson20.task1;

import lesson20.task1.exeption.BadRequestException;
import lesson20.task1.exeption.InternalServerException;
import lesson20.task1.exeption.UserNotFoundException;

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

    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");
        try {
            findOfDuplicate(user);
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        }catch (UserNotFoundException unf){
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }
        for (int i = 0; i < users.length; i++){
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        }
        throw new InternalServerException("Not enough space to save user with id: " + user.getId());
    }

    public User update(User user) throws Exception{
        if (user == null)
            throw new BadRequestException("Can't update null user");
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && user != null && users[i].getId() == user.getId()) {
                users[i] = new User(12345l, "Vyacheslav", "asdfgh");
                return users[i];
            }
        }
        throw new UserNotFoundException("User with id: " + user.getId() + " not found.");
    }

    public void delete(long id) throws Exception{
        for (int i = 0; i < users.length; i++)
            if (users[i] != null && users[i].getId() == id)
                users[i] = null;
        throw new UserNotFoundException("User with id: " + id + " not found.");
    }

    private User findById(long id) throws UserNotFoundException {
        for (int i = 0; i < users.length; i++)
            if (users[i] != null && users[i].getId() == id)
                return users[i];
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    private boolean findOfEmptyPlace(User[] inputUserArr) {
        for (User user : inputUserArr)
            if (user == null)
                return true;
        return false;
    }

    private boolean findOfDuplicate(User inputUserArr) throws UserNotFoundException {
        for (User us : users)
            if (us != null)
                if (findById(us.getId()) == inputUserArr)
                    return true;
        return false;
    }

    public void print(User[] userArr) {
        for (User us : userArr)
            if (us != null)
                System.out.println(us.getName());
    }
}
