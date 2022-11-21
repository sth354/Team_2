package is.hi.hbv501g.team_2.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private  int difficulty;
    private  int points;
    private  String username;

    public Score(int difficulty, int points, String username) {
        this.difficulty = difficulty;
        this.points = points;
        this.username = username;
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

    public String getUsername() {
        return username;
    }
}
