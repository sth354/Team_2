package is.hi.hbv501g.team_2.Services;

import is.hi.hbv501g.team_2.Persistence.Entities.Director;

import java.util.List;

// Update view 

public interface DirectorService {
    List<Director> findAll();

    Director getDirectorFromQueue();
    void removeDirectorFromQueue();
}
