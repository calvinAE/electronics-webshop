package ehb.be.webapp.repository;

import ehb.be.webapp.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

    @Override
    Optional<Cart> findById(Long aLong);

}
