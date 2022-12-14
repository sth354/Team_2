package is.hi.hbv501g.team_2.Controllers;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import is.hi.hbv501g.team_2.Persistence.Entities.*;

import is.hi.hbv501g.team_2.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
@Controller
public class GameController {
    private DirectorService directorService;
    private MovieService movieService;

    private FactService factService;
    private ScoreboardService scoreboardService;

    private UserService userService;

    // lives are number of lives during gameplay
    private int lives;
    private int score;

    // difficulty is number of movies during gameplay
    private int difficulty;

    private Director director;

    private Movie movieNotByDirector;


    @Autowired
    public GameController(UserService userService, DirectorService directorService, MovieService movieService, ScoreboardService scoreboardService, FactService factService) {
        this.directorService = directorService;
        this.movieService = movieService;
        this.scoreboardService = scoreboardService;
        this.factService = factService;
        this.userService = userService;
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

    /**
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

    @GetMapping("/")
    public String mainMenu(Model model) throws IOException, GeoIp2Exception {
        model.addAttribute("fact",factService.getRandomFact());
        String userCountry;
        userCountry = "/Flags/" + (userService.lookupCountry()) + ".svg";
        model.addAttribute("userCountry",userCountry);
        return "main";
    }

    @RequestMapping("/difficulty")
    public String difficultyMenu(Model model) {
        return "difficulty";
    }

    /**
     * Adds a random director to the specified model.
     *
     * @param model
     * @return the Director added to the model.
     */
    private Director addRandomDirectorToModel(Model model) {
        director = directorService.getDirectorFromQueue();
        model.addAttribute("director", director);
        return director;
    }

    private void setDifficulty(Model model){
        Director director = addRandomDirectorToModel(model);

        List<Movie> moviesFromDirector = movieService.getMoviesFromDirector(director, 1);
        List<Movie> moviesNotFromDirector = movieService.getMoviesNotFromDirector(director, this.difficulty, moviesFromDirector.size());

        ArrayList<Movie> movies = new ArrayList<>(moviesFromDirector);
        movies.addAll(moviesNotFromDirector);
        Collections.shuffle(movies);

        model.addAttribute("movies",movies);
    }

    /**
     * Sets up the gameplay page.
     * First checks if lives are <=0, if so then go to end game screen.
     * Else, the game page is initialized according to the difficulty chosen
     *
     * @param model the model
     * @param session the Http session
     */
    @RequestMapping("/game")
    public String gamePage(Model model, HttpSession session) {
        if (lives <= 0) {
            return endGame(model, session);
        }
        setDifficulty(model);

        model.addAttribute("lives",lives);
        model.addAttribute("score",score);

        return "game";
    }

    /**
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
        movieService.resetCachedMovies();
        directorService.removeDirectorFromQueue();
        return "redirect:/game";
    }

    //TODO: ??tti ??etta a?? vera h??rna?
    private void saveScore(Model model, HttpSession session){
        User user = (User) session.getAttribute("LoggedInUser");

        scoreboardService.save(new Score(this.difficulty, this.score, user));
        // ??etta er mad sus breyta ??essu seinna ?? getScore()
        // bara for testing purposes
    }

    @RequestMapping(value = "/end")
    private String endGame(Model model, HttpSession session) {
        if (session.getAttribute("LoggedInUser") != null){
            saveScore(model, session);
        }
        model.addAttribute("score", score);
        return "end";
    }
}
