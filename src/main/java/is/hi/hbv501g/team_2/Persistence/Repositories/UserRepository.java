package is.hi.hbv501g.team_2.Persistence.Repositories;

import is.hi.hbv501g.team_2.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    List<User> findAll();
    User findByUsername(String userName);
    void delete(User user);
    User findUserByID(long ID);
}
