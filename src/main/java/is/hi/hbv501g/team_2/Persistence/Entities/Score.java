package is.hi.hbv501g.team_2.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int difficulty;
    private int points;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Score(int difficulty, int points, User user) {
        this.difficulty = difficulty;
        this.points = points;
        this.user = user;
    }

    public Score() {

    }

    private long getID() {
        return ID;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getPoints() {
        return points;
    }

    public User getUser() {
        return this.user;
    }
}
