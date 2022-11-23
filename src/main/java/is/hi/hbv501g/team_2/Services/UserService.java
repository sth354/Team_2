package is.hi.hbv501g.team_2.Services;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import is.hi.hbv501g.team_2.Persistence.Entities.User;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findByUsername(String username);
    User login(User user);

    String lookupCountry() throws IOException, GeoIp2Exception;

    List<User> findAllByUsername(String username);
    void delete(User user);

}
