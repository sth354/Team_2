package is.hi.hbv501g.team_2.Services;

import is.hi.hbv501g.team_2.Persistence.Entities.Fact;

import java.util.List;

public interface FactService {

    List<Fact> findAll();

    Fact getRandomFact();
}
