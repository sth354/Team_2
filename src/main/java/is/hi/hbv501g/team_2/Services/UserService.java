package is.hi.hbv501g.team_2.Services;

import is.hi.hbv501g.team_2.Persistence.Entities.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findByUsername(String username);
    User login(User user);

    List<User> findAllByUsername(String username);
    void delete(User user);

}
