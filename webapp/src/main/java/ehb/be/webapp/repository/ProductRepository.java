package ehb.be.webapp.repository;

import ehb.be.webapp.model.Category;
import ehb.be.webapp.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

 Product findById(int Id);

 public List<Product> findByCategory(Category category);

 public List<Product> findByName(String name);

 public List<Product> deleteById(int id);
}
