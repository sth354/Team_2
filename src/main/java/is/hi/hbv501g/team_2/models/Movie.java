package is.hi.hbv501g.team_2.models;

public class Movie {

    private final String movieId;
    private final String title;
    private final Integer year;

    public Movie(String movieId, String title, Integer year) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() { return title + " (" + year + ")"; }

}
