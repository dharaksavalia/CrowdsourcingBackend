package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Bids;
import neu.edu.entity.Startup;
@Repository
public interface BidDao extends JpaRepository<Bids, Integer> {
	List<Bids>findByStartup(Startup startup);
	
}
