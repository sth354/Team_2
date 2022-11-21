package is.hi.hbv501g.team_2.Controllers;

import is.hi.hbv501g.team_2.Persistence.Entities.Score;
import is.hi.hbv501g.team_2.Services.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ScoreController {
    private ScoreboardService scoreboardService;

    @Autowired
    public ScoreController(ScoreboardService scoreboardService) {
        this.scoreboardService = scoreboardService;
    }

    @GetMapping("/viewScoreboards")
    public ModelAndView viewScoreboards() {
        ModelAndView mav = new ModelAndView("viewScores");
        List<Score> top10 = scoreboardService.topTenScoresHard( 7);
        //for (Score score : top10) {
        //    System.out.println(score.getUsername());
        //}
        mav.addObject("topTenHard", top10);
        return mav;
    }


    @RequestMapping("/endScreen")
    public String endScreen() {

       return "end";
    }
}
