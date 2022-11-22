package is.hi.hbv501g.team_2.Services.Implementation;

import is.hi.hbv501g.team_2.Persistence.Entities.Score;
import is.hi.hbv501g.team_2.Persistence.Entities.User;
import is.hi.hbv501g.team_2.Persistence.Repositories.ScoreboardRepository;
import is.hi.hbv501g.team_2.Services.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreboardServiceImplementation implements ScoreboardService {
    private ScoreboardRepository scoreboardRepository;

    @Autowired
    public ScoreboardServiceImplementation(ScoreboardRepository scoreboardRepository) {
        this.scoreboardRepository = scoreboardRepository;
    }

    @Override
    public Score save(Score score) {
        return scoreboardRepository.save(score);
    }

    @Override
    public List<Score> findByDifficulty(int difficulty) {
        return scoreboardRepository.findByDifficulty(difficulty);
    }

    @Override
    public List<Score> findByUser(User user) {
        return scoreboardRepository.findByUser(user);
    }

    @Override
    public List<Score> topTenScoresByDiff(int difficulty) {
        //lmao
        return scoreboardRepository.findTop10ByDifficultyOrderByPointsAsc(difficulty);
    }

    @Override
    public List<Score> topTenScoresAll() {
        return scoreboardRepository.findTop10ByOrderByPointsDesc();
    }


    @Override
    public List<Score> findAll(){
        return scoreboardRepository.findAll();
    }
}
