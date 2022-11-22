package is.hi.hbv501g.team_2.Services.Implementation;

import is.hi.hbv501g.team_2.Persistence.Entities.MovieData;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService {

    //if youre reading this on github plz dont steal
    private String API_KEY = "?api_key=b178c094ecebcdbc2e6a2280f9ebc33f&language=en-US";
    private String uri = "https://api.themoviedb.org/3/movie/";

    private String movie_id;

    public String prepareURI(long movie_id){
        return uri + movie_id + API_KEY;
    }

    @ResponseBody
    public MovieData getMovieResponse(long movie_id) {
        String uri = prepareURI(movie_id);
        RestTemplate restTemplate = new RestTemplate();
        MovieData movieData = restTemplate.getForObject(uri, MovieData.class);
        return movieData;
    }

    // "https://api.themoviedb.org/3/movie/550?api_key=b178c094ecebcdbc2e6a2280f9ebc33f&language=en-US";

}
