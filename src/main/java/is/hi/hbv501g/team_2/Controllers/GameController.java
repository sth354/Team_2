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

import java.util.*;
@Controller
public class GameController {
    private DirectorService directorService;
    private MovieService movieService;

    // lives are number of lives during gameplay
    private int lives;
    private int score;

    // difficulty is number of movies during gameplay
    private int difficulty;

    private Director director;

    private Movie movieNotByDirector;


    @Autowired
    public GameController(DirectorService directorService, MovieService movieService) {
        this.directorService = directorService;
        this.movieService = movieService;
    }

    /**
     * Called when hard difficulty is selected
     * Initializes game with hard difficulty
     */
    @RequestMapping( "/hard")
    public String getLivesHard(Model model){
        this.lives = 1;
        this.difficulty = 7;
        this.score = 0;
        return "redirect:/game";
    }

    /**
     * Called when medium difficulty is selected
     * Initializes game with easy difficulty
     */
    @RequestMapping( "/medium")
    public String getLivesMedium(Model model){
        this.lives = 4;
        this.difficulty = 4;
        this.score = 0;
        return "redirect:/game";
    }

    /* *
     * Called when easy difficulty is selected
     * Initializes game with easy difficulty
     * */
    @RequestMapping( "/easy")
    public String getLivesEasy(Model model){
        this.lives = 8;
        this.difficulty= 3;
        this.score = 0;
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

    //Adds random director
    private Director addRandomDirectorToModel(Model model) {
        director = directorService.getRandomDirector();
        model.addAttribute("director", director);
        return director;
    }

    private void setDifficulty(Model model){
        Director director = addRandomDirectorToModel(model);

        // Todo: Temporary extra difficulty, refactor later
        Integer numMoviesFromDirector = (int)(Math.random() * 2 + 1);
        List<Movie> moviesFromDirector = movieService.getMoviesFromDirector(director, numMoviesFromDirector);

        // If director does not have numMoviesFromDirector movies, we use more random movies
        Integer numMoviesNotFromDirector = this.difficulty - moviesFromDirector.size();
        List<Movie> moviesNotFromDirector = movieService.getMoviesNotFromDirector(director, numMoviesNotFromDirector);

        ArrayList<Movie> movies = new ArrayList<>(moviesFromDirector);
        movies.addAll(moviesNotFromDirector);
        Collections.shuffle(movies);

        model.addAttribute("movies",movies);
    }

    /* *
    * Sets up the gameplay page.
    * First checks if lives are <=0, if so then go to end game screen.
    * Else, the game page is initialized according to the difficulty chosen
    * */
    @RequestMapping("/game")
    public String gamePage(Model model) {
        if (lives <= 0) {
            return endGame(model);
        }
        setDifficulty(model);

        model.addAttribute("lives",lives);
        model.addAttribute("score",score);

        return "game";
    }

    /* *
    * Function that is called when the player chooses a movie during gameplay
    * If the answer is correct, then scores is increased by 1
    * Else, the player looses 1 life
    * */
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

    @RequestMapping(value = "/end")
    private String endGame(Model model) {
        model.addAttribute("score", score);
        return "end";
    }
}
