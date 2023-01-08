package ehb.be.webapp.controller;


import ehb.be.webapp.model.Category;
import ehb.be.webapp.model.User;
import ehb.be.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ModelAttribute("users")
    public Iterable<User> getAll(){ return userRepository.findAll(); }


    @GetMapping("/users")
    public String index(){

      return "/users/index";
    }

    @GetMapping("/users/makeAdmin")
    public String makeAdmin(Long id){
       Optional<User> user =  userRepository.findById(id);
        user.get().setRole("Admin");
        userRepository.save(user.get());
        return "redirect:/users";
    }


}
