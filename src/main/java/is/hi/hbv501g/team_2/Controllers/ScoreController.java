package is.hi.hbv501g.team_2.Controllers;

import is.hi.hbv501g.team_2.Services.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ScoreController {
    private ScoreboardService scoreboardService;

    @Autowired
    public ScoreController(ScoreboardService scoreboardService) {
        this.scoreboardService = scoreboardService;
    }
}
