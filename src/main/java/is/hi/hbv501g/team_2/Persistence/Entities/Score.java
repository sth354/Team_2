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

    private String username;

    public Score() {
    }

    public Score(int difficulty, int points, String username) {
        this.difficulty = difficulty;
        this.points = points;
        this.username = username;
    }
}
