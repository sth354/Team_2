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

    private List<Movie> moviesFromCurrentDirector;
    private List<Movie> moviesNotFromCurrentDirector;

    @Autowired
    public MovieServiceImplementation(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
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
     * @param movies The list of movies to select from
     * @param numberOfMovies The number random movies to select
     * @return A list of random movies from the given list
     */
    private List<Movie> getRandomWithoutReplacement(List<Movie> movies, Integer numberOfMovies) {
        if (numberOfMovies > movies.size()) {
            throw new IllegalArgumentException("Number of movies to select is larger than the list of movies");
        }

        List<Integer> permutation = getRandomPermutationRange(movies.size());
        List<Movie> randomMovies = new ArrayList<>();
        for (int i = 0; i < numberOfMovies; i++) {
            randomMovies.add(movies.get(permutation.get(i)));
        }
        return randomMovies;
    }

    /**
     * Returns a list of size numberOfMovies containing movies that are not from the given director
     * @param director The director to exclude
     * @param difficulty The difficulty of the game, i.e. the number of movies
     * @param numberOfActualMovies The number of movies which are from the prompted director
     * @return List<Movie>
     */
    @Override
    public List<Movie> getMoviesNotFromDirector(Director director, Integer difficulty, Integer numberOfActualMovies) {
        Integer numberOfMovies = difficulty - numberOfActualMovies;

        // TODO: This is not optimal since if numberOfActualMovies is random then a user could reset the game repeatedly
        if (moviesNotFromCurrentDirector != null && numberOfMovies != moviesNotFromCurrentDirector.size()) {
            moviesNotFromCurrentDirector = null;
        }

        if (moviesNotFromCurrentDirector == null) {
            List<Movie> allMovies = movieRepository.findMoviesByDirectorIsNot(director);
            moviesNotFromCurrentDirector = getRandomWithoutReplacement(allMovies, numberOfMovies);
        }

        return moviesNotFromCurrentDirector;
    }

    /**
     * Returns a list of size numberOfMovies containing movies that are from the given director
     * @param director The director to exclude
     * @param numberOfMovies The number of movies to return
     * @return List<Movie>
     */
    @Override
    public List<Movie> getMoviesFromDirector(Director director, Integer numberOfMovies) {
        if (moviesFromCurrentDirector == null) {
            List<Movie> allMovies = director.getMovies();
            Integer numberOfMoviesToSelect = Math.min(numberOfMovies, allMovies.size());
            moviesFromCurrentDirector = getRandomWithoutReplacement(allMovies, numberOfMoviesToSelect);
        }
        return moviesFromCurrentDirector;
    }

    @Override
    public void resetCachedMovies() {
        moviesFromCurrentDirector = null;
        moviesNotFromCurrentDirector = null;
    }

}
