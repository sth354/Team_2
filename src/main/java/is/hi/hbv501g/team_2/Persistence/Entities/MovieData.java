package is.hi.hbv501g.team_2.Persistence.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieData {

    private String poster_path;

    private String original_title;

    private String release_date;

    private String vote_average;

    private String runtime;

    public String getRelease_date() {
        return release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String makePoster() {
        return "https://image.tmdb.org/t/p/w500" + this.poster_path;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getRuntime() {
        return runtime;
    }
}
