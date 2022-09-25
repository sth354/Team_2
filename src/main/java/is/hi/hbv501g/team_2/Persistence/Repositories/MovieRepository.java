package is.hi.hbv501g.team_2.Persistence.Repositories;

import is.hi.hbv501g.team_2.Persistence.Entities.Director;
import is.hi.hbv501g.team_2.Persistence.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByID(long ID);

    List<Movie> findAll();

    List<Movie> getMovieByDirectorEqualsIgnoreCase(Director director);
}
