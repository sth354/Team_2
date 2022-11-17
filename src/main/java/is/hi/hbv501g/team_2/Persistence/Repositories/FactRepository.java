package is.hi.hbv501g.team_2.Persistence.Repositories;

import is.hi.hbv501g.team_2.Persistence.Entities.Fact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactRepository extends JpaRepository<Fact, Long> {

    List<Fact> findAll();

}
