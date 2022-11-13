package is.hi.hbv501g.team_2.Controllers;

import is.hi.hbv501g.team_2.Services.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        mav.addObject("scores",scoreboardService.findAll());
        return mav;
    }


    @RequestMapping("/endScreen")
    public String endScreen() {

       return "end";
    }
}
