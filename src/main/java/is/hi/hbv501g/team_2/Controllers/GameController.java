package is.hi.hbv501g.team_2.Controllers;

import is.hi.hbv501g.team_2.Services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {
    private DirectorService directorService;

    @Autowired
    public GameController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @RequestMapping("/game")
    public String gamePage(Model model) {

        // make game... xD

        return "game";
    }
}