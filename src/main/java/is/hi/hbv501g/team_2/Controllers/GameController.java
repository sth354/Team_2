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

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class GameController {
    private DirectorService directorService;
    private MovieService movieService;
    private int lives;
    private int score;

    private Director director;


    @Autowired
    public GameController(DirectorService directorService, MovieService movieService) {
        this.directorService = directorService;
        this.movieService = movieService;
        lives = 3;
        score = 0;
    }

    @RequestMapping("/")
    public String mainMenu() {
        return "main";
    }

    @RequestMapping("/game")
    public String gamePage(Model model) {
        if (lives <= 0) {
            return endGame(model);
        }

        director = directorService.getRandomDirector();
        Movie movie = movieService.getRandomMovieFromDirector(director);
        Movie randomMovie = movieService.getRandomMovieNotFromDirector(director);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies.add(randomMovie);
        Collections.shuffle(movies);

        model.addAttribute("director", director);
        model.addAttribute("movie1", movies.get(0));
        model.addAttribute("movie2", movies.get(1));
        model.addAttribute("lives",lives);
        model.addAttribute("score",score);

        return "game";
    }

    @RequestMapping(value = "/checkAnswer", method = RequestMethod.GET)
    public String checkAnswer(@RequestParam String action, Model model) {
        if (director.contains(action)) {
            score++;
        }
        else {
            lives--;
        }
        return "redirect:/game";
    }

    @RequestMapping(value = "/end", method = RequestMethod.GET)
    private String endGame(Model model) {
        model.addAttribute("score",score);
        lives = 3;
        score = 0;
        return "end";
    }
}
