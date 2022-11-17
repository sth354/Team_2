package is.hi.hbv501g.team_2.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "facts")
public class Fact {

    private String fact;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    public Fact(){}

    public long getID() {
        return ID;
    }

    public String getFact() {
        return fact;
    }

    @Override
    public String toString() {
        return fact;
    }
}
