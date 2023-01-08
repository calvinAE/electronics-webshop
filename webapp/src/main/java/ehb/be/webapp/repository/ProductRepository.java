package ehb.be.webapp.repository;

import ehb.be.webapp.model.Category;
import ehb.be.webapp.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

 Product findById(int Id);

 public List<Product> findByCategory(Category category);

 public List<Product> findByName(String name);

 public List<Product> deleteById(int id);

 @Query(value ="select * from Product where name like %:keyword%",nativeQuery = true)
 public List<Product> findByKeyword(@Param("keyword") String keyword);
}
