package is.hi.hbv501g.team_2.Controllers;

import is.hi.hbv501g.team_2.Persistence.Entities.Director;
import is.hi.hbv501g.team_2.Services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GameController {
    private DirectorService directorService;

    @Autowired
    public GameController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @RequestMapping("/game")
    public String gamePage(Model model) {

        List<Director> directors = directorService.findAll();
        int random = (int)(Math.random() * 3);
        model.addAttribute("directors",directors);
        // make game... xD

        return "game";
    }
}
