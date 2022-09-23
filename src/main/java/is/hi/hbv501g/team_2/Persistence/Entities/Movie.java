package is.hi.hbv501g.team_2.Persistence.Entities;

public class Movie {
    private long ID;
    private  String title;
    private  Integer year;

    public Movie() {
    }

    public Movie(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() { return title + " (" + year + ")"; }

}
