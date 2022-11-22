package is.hi.hbv501g.team_2.Services;

import is.hi.hbv501g.team_2.Persistence.Entities.Director;
import is.hi.hbv501g.team_2.Persistence.Entities.Movie;

import java.util.List;

public interface MovieService {
    Movie findByID(long ID);

    List<Movie> findAll();

    Movie getRandomMovie();

    List<Movie> getMoviesNotFromDirector(Director director, Integer numberOfMovies);

    List<Movie> getMoviesFromDirector(Director director, Integer numberOfMovies);

}
