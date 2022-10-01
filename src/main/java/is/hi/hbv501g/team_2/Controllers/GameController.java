package is.hi.hbv501g.team_2.Controllers;

import is.hi.hbv501g.team_2.Persistence.Entities.Director;
import is.hi.hbv501g.team_2.Persistence.Entities.Movie;
import is.hi.hbv501g.team_2.Services.DirectorService;
import is.hi.hbv501g.team_2.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GameController {
    private DirectorService directorService;
    private MovieService movieService;
    private int lives;

    @Autowired
    public GameController(DirectorService directorService, MovieService movieService) {
        this.directorService = directorService;
        this.movieService = movieService;
        lives = 3;
    }

    @RequestMapping("/game")
    public String gamePage(Model model) {

        Director director = directorService.getRandomDirector();

        Movie movie = movieService.getRandomMovieFromDirector(director);

        model.addAttribute("director", director);
        model.addAttribute("movie", movie);
        model.addAttribute("randomMovie", movieService.getRandomMovie(movie));
        model.addAttribute("lives",lives);
        // make game... xD

        return "game";
    }

    @RequestMapping(value = "/checkAnswer", method = RequestMethod.GET)
    public String checkAnswer(@RequestParam String action, Model m) {
        System.out.println(action);
        return "redirect:/game";
    }
}
