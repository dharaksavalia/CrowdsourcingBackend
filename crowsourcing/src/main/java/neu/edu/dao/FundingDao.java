package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Funding;

@Repository
public interface FundingDao extends JpaRepository<Funding, Integer> {

}
