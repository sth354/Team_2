package is.hi.hbv501g.team_2.Persistence.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String userName;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "director", cascade =  CascadeType.ALL)
    private List<Score> scores;

    protected User() {
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() { return userName; }

}
