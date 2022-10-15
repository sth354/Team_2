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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Controller
public class GameController {
    private DirectorService directorService;
    private MovieService movieService;
    private int lives;
    private int score;

    private int difficulty;

    private Director director;

    private Movie movieNotByDirector;


    @Autowired
    public GameController(DirectorService directorService, MovieService movieService) {
        this.directorService = directorService;
        this.movieService = movieService;
        this.score = 0;
    }

    @RequestMapping( "/hard")
    public String getLivesHard(Model model){
        this.lives = 1;
        this.difficulty = 7;
        return "redirect:/game";
    }
    @RequestMapping( "/medium")
    public String getLivesMedium(Model model){
        this.lives = 4;
        this.difficulty = 4;
        return "redirect:/game";
    }

    @RequestMapping( "/easy")
    public String getLivesEasy(Model model){
        this.lives = 8;
        this.difficulty= 3;
        return "redirect:/game";
    }

    @RequestMapping("/")
    public String mainMenu() {
        return "main";
    }

    @RequestMapping("/difficulty")
    public String difficultyMenu(Model model) {
        return "difficulty";
    }


    private Director addRandomDirectorToModel(Model model) {
        director = directorService.getRandomDirector();
        model.addAttribute("director", director);
        return director;
    }

    private void setDifficulty(Model model){
        HashMap<Movie,Movie> moviesMap = new HashMap<>();
        Director director = addRandomDirectorToModel(model);
        Movie correctMovie = movieService.getRandomMovieFromDirector(director);
        while (moviesMap.size() < this.difficulty - 1) {
            movieNotByDirector = movieService.getRandomMovieNotFromDirector(director);
            moviesMap.putIfAbsent(movieNotByDirector,movieNotByDirector);
        }
        List<Movie> movies = new ArrayList<Movie>(moviesMap.values());
        movies.add(correctMovie);
        Collections.shuffle(movies);
        model.addAttribute("movies",movies);
    }

    @RequestMapping("/game")
    public String gamePage(Model model) {
        if (lives <= 0) {
            return endGame(model);
        }
        //TODO: delete duplicate values in movies array
        setDifficulty(model);

        model.addAttribute("lives",lives);
        model.addAttribute("score",score);

        return "game";
    }

    @RequestMapping(value = "/checkAnswer", method = RequestMethod.GET)
    public String checkAnswer(@RequestParam String action, Model model, RedirectAttributes redirAttrs) {
        if (director.contains(action)) {
            redirAttrs.addFlashAttribute("success", "correct!");
            score++;
        }
        else {
            redirAttrs.addFlashAttribute("fail", "that was incorrect :(");
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
