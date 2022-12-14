package is.hi.hbv501g.team_2.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String title;
    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    private Director director;

    protected Movie() {
    }

    public Movie(String title, Integer year, Director director) {
        this.title = title;
        this.year = year;
        this.director = director;
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

    @Override
    public int hashCode(){
        return (int) (getID() ^ (getID() >>> 32));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Movie that = (Movie) o;
        return ID == that.ID
                && (title.equals(that.title)
                && year.equals(that.year));
    }

}
