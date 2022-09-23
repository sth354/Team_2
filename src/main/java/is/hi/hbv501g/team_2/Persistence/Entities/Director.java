package is.hi.hbv501g.team_2.Persistence.Entities;

import java.util.ArrayList;

public class Director {
    private long ID;
    private String name;
    private ArrayList<Movie> movies;

    public Director() {
    }

    public Director(String name, ArrayList<Movie> movies) {
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

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return name;
    }

}
