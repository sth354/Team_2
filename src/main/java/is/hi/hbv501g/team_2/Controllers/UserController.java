package is.hi.hbv501g.team_2.Controllers;

import is.hi.hbv501g.team_2.Persistence.Entities.User;
import is.hi.hbv501g.team_2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

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
    public String signupPOST(User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/signup";
        }
        User exists = userService.findByUsername(user.getUsername());
        if(exists == null){

            userService.save(user);
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
     * @param model The model that is used to display the login form
     * @param session The session that is used to store the user
     * @return The login page if the form is invalid, otherwise the main page
     */
    public String loginPOST(User user, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "login";
        }
        User exists = userService.login(user);
        if(exists != null){
            session.setAttribute("LoggedInUser", exists);
            model.addAttribute("LoggedInUser", exists);
        }
        return "loggedIn";
    }
}
