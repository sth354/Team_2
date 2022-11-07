package is.hi.hbv501g.team_2.Persistence.Repositories;

import is.hi.hbv501g.team_2.Persistence.Entities.Score;
import is.hi.hbv501g.team_2.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreboardRepository extends JpaRepository<Score, Long> {
    Score save(Score score);
    List<Score> findByDifficulty(int difficulty);
    List<Score> findByUser(User user);
    List<Score> findAll();
}
