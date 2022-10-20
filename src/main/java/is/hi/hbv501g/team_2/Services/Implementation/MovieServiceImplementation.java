package is.hi.hbv501g.team_2.Services.Implementation;

import is.hi.hbv501g.team_2.Persistence.Entities.Director;
import is.hi.hbv501g.team_2.Persistence.Entities.Movie;
import is.hi.hbv501g.team_2.Persistence.Repositories.MovieRepository;
import is.hi.hbv501g.team_2.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    /**
     * Returns a list of size numberOfMovies containing movies that are not from the given director
     * @param director The director to exclude
     * @param numberOfMovies The number of movies to return
     * @return List<Movie>
     */
    @Override
    public List<Movie> getMoviesNotFromDirector(Director director, Integer numberOfMovies) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < numberOfMovies; i++) indices.add(i);
        Collections.shuffle(indices);

        List<Movie> randomMovies = new ArrayList<>();
        List<Movie> allMovies = movieRepository.findMoviesByDirectorIsNot(director);

        for (int i = 0; i < numberOfMovies || i < randomMovies.size(); i++) {
            randomMovies.add(allMovies.get(indices.get(i)));
        }

        return randomMovies;
    }


    @Override
    public List<Movie> getMoviesFromDirector(Director director, Integer numberOfMovies) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < numberOfMovies; i++) indices.add(i);
        Collections.shuffle(indices);

        List<Movie> randomMovies = new ArrayList<>();
        List<Movie> allMovies = director.getMovies();

        for (int i = 0; i < numberOfMovies || i < randomMovies.size(); i++) {
            randomMovies.add(allMovies.get(indices.get(i)));
        }

        return randomMovies;
    }

}
