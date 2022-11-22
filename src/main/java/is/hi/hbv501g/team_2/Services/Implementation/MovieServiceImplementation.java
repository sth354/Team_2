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
     * @param n The upper limit of the range
     * @return Random permutation of [0, 1, ..., n-1]
     */
    private List<Integer> getRandomPermutationRange(Integer n) {
        List<Integer> permutation = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            permutation.add(i);
        }
        Collections.shuffle(permutation);
        return permutation;
    }

    /**
     * Returns a list of size numberOfMovies containing movies that are not from the given director
     * @param director The director to exclude
     * @param numberOfMovies The number of movies to return
     * @return List<Movie>
     */
    @Override
    public List<Movie> getMoviesNotFromDirector(Director director, Integer numberOfMovies) {
        List<Integer> indices = getRandomPermutationRange(numberOfMovies);

        List<Movie> randomMovies = new ArrayList<>();
        List<Movie> allMovies = movieRepository.findMoviesByDirectorIsNot(director);

        for (int i = 0; i < numberOfMovies && i < allMovies.size(); i++) {
            randomMovies.add(allMovies.get(indices.get(i)));
        }

        return randomMovies;
    }

    /**
     * Returns a random movie
     * @return Movie
     */
    public Movie getRandomMovie() {
        List<Movie> l =  movieRepository.findAll();
        Random rand = new Random();
        return l.get(rand.nextInt(l.size()));
    }

    /**
     * Returns a list of size numberOfMovies containing movies that are from the given director
     * @param director The director to exclude
     * @param numberOfMovies The number of movies to return
     * @return List<Movie>
     */
    @Override
    public List<Movie> getMoviesFromDirector(Director director, Integer numberOfMovies) {
        List<Movie> allMovies = director.getMovies();

        Integer numMovies = Math.min(numberOfMovies, allMovies.size());

        List<Integer> indices = getRandomPermutationRange(numMovies);

        List<Movie> randomMovies = new ArrayList<>();
        for (int i = 0; i < numMovies; i++) {
            randomMovies.add(allMovies.get(indices.get(i)));
        }

        return randomMovies;
    }

}
