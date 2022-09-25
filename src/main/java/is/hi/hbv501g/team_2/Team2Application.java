package is.hi.hbv501g.team_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class Team2Application {
    //This is Freyr's comment
    //Axel's commit and another commit from testbranch
    //Bjarni :)
    public static void main(String[] args) {
        SpringApplication.run(Team2Application.class, args);
    }
}
