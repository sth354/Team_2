package is.hi.hbv501g.team_2.Services.Implementation;

import is.hi.hbv501g.team_2.Persistence.Entities.Director;
import is.hi.hbv501g.team_2.Persistence.Entities.Movie;
import is.hi.hbv501g.team_2.Persistence.Repositories.MovieRepository;
import is.hi.hbv501g.team_2.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {
    private MovieRepository movieRepository;

    private List<Movie> allMovies;

    @Autowired
    public MovieServiceImplementation(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        this.allMovies = movieRepository.findAll();
    }

    @Override
    public Movie findByID(long ID) {
        return movieRepository.findByID(ID);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getRandomMovie(Movie movie) {
        while (true) {
            int random = (int) (Math.random() * allMovies.size());
            if (!allMovies.get(random).equals(movie)) {
                return allMovies.get(random);
            }
        }
    }

    @Override
    public Movie getRandomMovieNotFromDirector(Director director) {
        List<Movie> movies = movieRepository.findMoviesByDirectorIsNot(director);
        int random = (int)(Math.random() * movies.size());
        return movies.get(random);
    }


    @Override
    public Movie getRandomMovieFromDirector(Director director) {
        List<Movie> movies = director.getMovies();
        int random = (int)(Math.random() * movies.size());
        return movies.get(random);
    }

}
