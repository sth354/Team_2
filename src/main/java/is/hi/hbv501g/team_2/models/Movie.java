package is.hi.hbv501g.team_2.models;

public class Movie {

    private String movieId;
    private String title;
    private Integer year;

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
    public String toString() {
        return "Movie [movieId=" + movieId + ", title=" + title + ", year=" + year + "]";
    }

}
