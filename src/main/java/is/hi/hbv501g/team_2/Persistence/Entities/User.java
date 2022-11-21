package is.hi.hbv501g.team_2.Persistence.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String username;
    private String password;

    //@OneToMany(mappedBy = "user", cascade =  CascadeType.ALL, orphanRemoval = true)
    //private List<Score> scores;

    protected User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() { return username; }

}
