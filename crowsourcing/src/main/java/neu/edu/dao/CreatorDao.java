package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Creator;

@Repository
public interface CreatorDao extends JpaRepository<Creator, Integer> {

}
