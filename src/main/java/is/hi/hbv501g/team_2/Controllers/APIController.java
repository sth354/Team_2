package is.hi.hbv501g.team_2.Controllers;

import is.hi.hbv501g.team_2.Persistence.Entities.Movie;
import is.hi.hbv501g.team_2.Persistence.Entities.MovieData;
import is.hi.hbv501g.team_2.Services.Implementation.MovieServiceImplementation;
import is.hi.hbv501g.team_2.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import is.hi.hbv501g.team_2.Services.Implementation.APIService;

@Controller
public class APIController {
    APIService apiService = new APIService();
    private MovieService movieService;

    @Autowired
    public APIController(MovieService movieService){
        this.movieService = movieService;
    }
    private MovieData getMovieData() {
        Movie movie = movieService.getRandomMovie();
        return apiService.getMovieResponse(movie.getID());
    }

    @GetMapping("/movie-of-the-day")
    public ModelAndView movieOfTheDay(){

        ModelAndView mav = new ModelAndView("movie-of-the-day");
        mav.addObject("randomMovie", getMovieData());
        return mav;
    }
}
