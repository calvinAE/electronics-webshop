package ehb.be.webapp.service;

import ehb.be.webapp.model.Cart;
import ehb.be.webapp.model.CartItem;
import ehb.be.webapp.repository.CartItemRepository;
import ehb.be.webapp.repository.ProductRepository;
import ehb.be.webapp.model.Category;
import ehb.be.webapp.model.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> filterByKeyword(String keyword) { return productRepository.findByKeyword(keyword);}
}
