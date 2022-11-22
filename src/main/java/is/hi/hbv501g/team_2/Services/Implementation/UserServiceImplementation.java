package is.hi.hbv501g.team_2.Services.Implementation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;
import is.hi.hbv501g.team_2.Persistence.Entities.User;
import is.hi.hbv501g.team_2.Persistence.Repositories.UserRepository;
import is.hi.hbv501g.team_2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {


    @Autowired
    private HttpServletRequest request;
    private String ipString;
    private InetAddress ipAddress;

    private File countryDatabase = new File("src/data/GeoLite2-Country.mmdb");
    private CountryResponse response;
    private DatabaseReader reader;

    private Country country;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        user.setPassword(get_SHA_512_SecurePassword(user.getPassword(),"salt"));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    /**
     * Function that checks whether login attempt matches our user database
     * @param user The login attempt
     * @return user if username and password match, otherwise null
     */
    public User login(User user) {
        User doesExist = findByUsername(user.getUsername());
            if (doesExist != null) {
                if (doesExist.getPassword().equals(get_SHA_512_SecurePassword(user.getPassword(),"salt"))) {
                    return doesExist;
                }
            }
        return null;
    }

    public String get_SHA_512_SecurePassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    /**
     * Deletes a user
     * @param user the user to be deleted
     */
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    public String lookupCountry() throws IOException, GeoIp2Exception {
        reader = new DatabaseReader.Builder(countryDatabase).build();
        //ipString = request.getRemoteAddr();
        //ipAddress = InetAddress.getByName(ipString);
        //change this line to the two comments above - For testing purposes a standard Icelandic IP;
        ipAddress = InetAddress.getByName("46.182.187.211");
        response = reader.country(ipAddress);
        country = response.getCountry();
        return country.getIsoCode();
    }
}
