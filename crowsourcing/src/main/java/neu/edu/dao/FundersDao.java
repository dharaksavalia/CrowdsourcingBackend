package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Funders;
@Repository
public interface FundersDao extends JpaRepository<Funders, Integer> {

}
