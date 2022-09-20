package is.hi.hbv501g.team_2.models;

import java.util.ArrayList;

public class Director {
    private String name;
    private ArrayList<Movie> movies;

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
        return "Director [name=" + name + ", movies=" + movies + "]";
    }

}
