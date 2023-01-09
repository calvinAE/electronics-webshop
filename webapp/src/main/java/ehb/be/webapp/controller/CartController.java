package ehb.be.webapp.controller;

import ehb.be.webapp.model.User;
import ehb.be.webapp.repository.CartRepository;
import ehb.be.webapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;




    @RequestMapping("/cart")
    public String showCart(Model model) {
        return "/checkout/checkout";
    }


    @PostMapping("/addToCart")
    public String addToCart(@AuthenticationPrincipal User user, Model model, @RequestParam("id") Long id){

        if(user.getCart() == null){
            //Create a new cart
            cartService.addCart(id,user);

        } else {
            //Add to existing cart
            cartService.addToExistingCart(id,user.getCart().getId());}
        return "redirect:/";

    }

}
