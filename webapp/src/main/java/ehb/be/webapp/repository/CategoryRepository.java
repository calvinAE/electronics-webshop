package ehb.be.webapp.repository;

import ehb.be.webapp.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,Long> {


    public List<Category> findById(int Id);

    public List<Category> findByName(String name);

    public List<Category> deleteById(int id);
}
