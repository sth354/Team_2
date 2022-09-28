package is.hi.hbv501g.team_2.Controllers;

import is.hi.hbv501g.team_2.Persistence.Entities.Director;
import is.hi.hbv501g.team_2.Persistence.Entities.Movie;
import is.hi.hbv501g.team_2.Services.DirectorService;
import is.hi.hbv501g.team_2.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

        List<Director> directors = directorService.findAll();
        List<Movie> movies = movieService.findAll();
        int random = (int)(Math.random() * 2);
        int randomM = (int)(Math.random() * 2);
        model.addAttribute("director", directors.get(random));
        model.addAttribute("movie", directors.get(random).getMovies().get(random));
        model.addAttribute("randomMovie", movies.get(randomM));
        model.addAttribute("lives",lives);
        // make game... xD

        return "game";
    }
}
