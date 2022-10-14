package is.hi.hbv501g.team_2.Persistence.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "director", cascade =  CascadeType.ALL)
    private List<Movie> movies;

    protected Director() {
    }

    public Director(String name, List<Movie> movies) {
        //test comment git
        this.name = name;
        this.movies = movies;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
    //this is a commit from axel branch
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean contains(String toString) {
        for(int i = 0; i < movies.size(); i++) {
            if (movies.get(i).toString().equals(toString)) {
                return true;
            }
        }
        return false;
    }

}
