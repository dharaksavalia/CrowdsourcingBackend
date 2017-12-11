package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.ServiceDetail;

@Repository
public interface ServiceDetailDao extends JpaRepository<ServiceDetail, Integer> {

}
