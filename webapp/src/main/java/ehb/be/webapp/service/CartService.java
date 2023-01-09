package ehb.be.webapp.service;

import ehb.be.webapp.model.Cart;
import ehb.be.webapp.model.CartItem;
import ehb.be.webapp.model.User;
import ehb.be.webapp.repository.CartItemRepository;
import ehb.be.webapp.repository.CartRepository;
import ehb.be.webapp.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;


    //Create new cart
    public void addCart(Long id, User user){
        Cart cart = new Cart();
        cart.setUser(user);
        CartItem item = new CartItem();
        item.setQuantity(1);
        item.setProduct(productRepository.findById(id).get());
        cart.getItems().add(item);

        cartRepository.save(cart);

    }

    //If the user already has a cart
    public void addToExistingCart(Long id, Long cartId){
        Optional<Cart> cart = cartRepository.findById(cartId);

        if(cart.isPresent()){
        CartItem item = new CartItem();
        item.setQuantity(1);
        item.setProduct(productRepository.findById(id).get());
        cart.get().getItems().add(item);

        cartRepository.save(cart.get());
        }
    }
}
