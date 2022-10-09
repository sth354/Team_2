package is.hi.hbv501g.team_2.Services;

import is.hi.hbv501g.team_2.Persistence.Entities.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findByUserName(String userName);
    boolean checkUser(User user);
}
