package is.hi.hbv501g.team_2.models;

public class User {
    private final String userId;
    private final String userName;
    private final String password;

    public User(String userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() { return userName; }

}
