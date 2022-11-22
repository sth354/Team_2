package is.hi.hbv501g.team_2.Persistence.Entities;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import javax.xml.ws;

public class CountryIP {
    @Autowired
    private HttpServletRequest request;
    private WebServiceClient client;
    private String ipString;
    private InetAddress;
    private CountryResponse response;
    private Country country;

    public String getUserCountry() {
        ipString = request.getRemoteAddr();
        client = new WebServiceClient.Builder(793852, "license_key").build();
        ipAddress = InetAddress.getByName(ipString);
        response = client.country(ipAddress);
        country = response.getCountry();
        //System.out.println(country.getIsoCode());
        //System.out.println(country.getName());
        return country.getName();
    }
}
