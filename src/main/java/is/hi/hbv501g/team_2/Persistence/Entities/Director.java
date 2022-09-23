package is.hi.hbv501g.team_2.Persistence.Entities;

import java.util.ArrayList;

public class Director {
    private final String name;
    private final ArrayList<Movie> movies;

    public Director(String name, ArrayList<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return name;
    }

}
