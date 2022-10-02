package is.hi.hbv501g.team_2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String mainMenu() {
        //Business logic
        //Call a method in a Service Class
        //Add some data to the Model
        return "main";
    }
}
