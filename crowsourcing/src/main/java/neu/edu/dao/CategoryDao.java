package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
	List<Category>findByCatergoryName(String category);

}
