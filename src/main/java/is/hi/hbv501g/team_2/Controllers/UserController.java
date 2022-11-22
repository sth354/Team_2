package is.hi.hbv501g.team_2.Controllers;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import is.hi.hbv501g.team_2.Persistence.Entities.User;
import is.hi.hbv501g.team_2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.UnknownHostException;

@Controller
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupGET(User user){
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    /**
     * Function that handles the signup form, saves the new user if valid
     * @param user The user that is signing up
     * @param result The result of the signup form
     * @param model The model that is used to display the signup form
     * @return The signup page if the form is invalid, otherwise the main page
     */
    public String signupPOST(User user, BindingResult result, RedirectAttributes redirAttrs, Model model){
        if(result.hasErrors()){
            return "redirect:/signup";
        }
        User exists = userService.findByUsername(user.getUsername());
        if(exists == null){

            userService.save(user);
        }
        else {
            redirAttrs.addFlashAttribute("error_", "This username is already taken");
            return "redirect:/signup";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(User user){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    /**
     * Function that handles the login form, logs in the user if valid
     * @param user The user that is logging in
     * @param result The result of the login form
     * @param session The session that is used to store the user
     * @param redirAttrs The redirect attributes that are used to display error messages
     * @return The login page if the form is invalid, otherwise the main page
     */
    public String loginPOST(User user, BindingResult result, HttpSession session, RedirectAttributes redirAttrs) {
        if (result.hasErrors()) {
            redirAttrs.addFlashAttribute("error", "Unexpected error");
            return "redirect:/login";
        }
        User exists = userService.login(user);
        if (exists != null) {
            session.setAttribute("LoggedInUser", exists);
            return "redirect:/";
        }
        redirAttrs.addFlashAttribute("error", "Invalid username or password");
        return "redirect:/login";
    }

    @RequestMapping(value = "/logout")
    /**
     * Function that logs out the user
     * @param session The session that is used to store the user
     * @return The main page
     */
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/userCountry")
    public String userCountry() throws IOException, GeoIp2Exception {
        return userService.lookupCountry();
    }
}
