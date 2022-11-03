package is.hi.hbv501g.team_2.Controllers;

import is.hi.hbv501g.team_2.Services.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScoreController {
    private ScoreboardService scoreboardService;

    @Autowired
    public ScoreController(ScoreboardService scoreboardService) {
        this.scoreboardService = scoreboardService;
    }

    @RequestMapping("/viewScoreboards")
    public String viewScoreboards() {
        return "viewScores";
    }

    @RequestMapping("/scoreScreen")
    public String endScreen() {

       return "scores";
    }
}
