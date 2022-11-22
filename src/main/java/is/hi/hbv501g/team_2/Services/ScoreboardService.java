package is.hi.hbv501g.team_2.Services;

import is.hi.hbv501g.team_2.Persistence.Entities.Score;
import is.hi.hbv501g.team_2.Persistence.Entities.User;

import java.util.List;

public interface ScoreboardService {
    Score save(Score score);
    List<Score> findByDifficulty(int difficulty);
    List<Score> findByUser(User user);

    List<Score> topTenScoresByDiff(int difficulty);
    List<Score> topTenScoresAll();
    List<Score> findAll();
}
