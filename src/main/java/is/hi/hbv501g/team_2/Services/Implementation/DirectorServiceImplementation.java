package is.hi.hbv501g.team_2.Services.Implementation;

import is.hi.hbv501g.team_2.Controllers.MainController;
import is.hi.hbv501g.team_2.Persistence.Entities.Director;
import is.hi.hbv501g.team_2.Persistence.Entities.Movie;
import is.hi.hbv501g.team_2.Services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorServiceImplementation implements DirectorService {
    private List<Director> directorReposistory = new ArrayList<>();
    private int id_counter = 0;

    @Autowired
    public DirectorServiceImplementation() {
        // Create 3 random Directors - removed when jpa is added
        directorReposistory.add(new Director("D1", new ArrayList<Movie>() {{
            add(new Movie("M1",null));
            add(new Movie("M2",null));
            add(new Movie("M3",null));
        }}));
        directorReposistory.add(new Director("D2", new ArrayList<Movie>() {{
            add(new Movie("M4",null));
            add(new Movie("M5",null));
            add(new Movie("M6",null));
        }}));
        directorReposistory.add(new Director("D3", new ArrayList<Movie>() {{
            add(new Movie("M7",null));
            add(new Movie("M8",null));
            add(new Movie("M9",null));
        }}));
        //JPA gives ID - manually for now
        for(Director d: directorReposistory) {
            d.setID(id_counter);
            id_counter++;
        }
    }

    @Override
    public List<Director> findAll() {
        return directorReposistory;
    }
}
