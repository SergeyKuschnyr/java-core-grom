package lesson9;

/**
 * Created by Kushn_000 on 15.04.2017.
 */
public class User {
    private Long id;
    private String name;
    private String sessionId;

    public User(Long id, String name, String sessionId) {
        this.id = id;
        this.name = name;
        this.sessionId = sessionId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSessionId() {
        return sessionId;
    }
}
