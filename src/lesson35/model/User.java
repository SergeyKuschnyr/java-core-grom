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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        return TYPE == user.TYPE;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (TYPE != null ? TYPE.hashCode() : 0);
        return result;
    }
}
