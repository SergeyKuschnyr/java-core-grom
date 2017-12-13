package lesson35.model;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    UserType TYPE;

    public User(String userName, String password, String country, UserType TYPE) {
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.TYPE = TYPE;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getTYPE() {
        return TYPE;
    }

    public void setId(long id) {
        this.id = id;
    }
}
