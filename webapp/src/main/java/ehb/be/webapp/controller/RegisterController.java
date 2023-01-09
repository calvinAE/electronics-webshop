package ehb.be.webapp.controller;

import ehb.be.webapp.model.UserDTO;
import ehb.be.webapp.model.User;
import ehb.be.webapp.repository.UserRepository;
import ehb.be.webapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RegisterController {

    private final UserService userService;
    @Autowired
    private final UserRepository userRepository;


    @GetMapping("/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "/security/register";
    }

    @PostMapping("/registration")
    public String registerUserAccount(
            @ModelAttribute("user") UserDTO user,
            BindingResult result,
            Errors errors) {

        try {
            if(userRepository.findByUsername(user.getUsername()) == null){
                User registered = userService.registerNewUserAccount(user);
            } else {
                String error = "User already exists!";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/login?register";
    }

}


