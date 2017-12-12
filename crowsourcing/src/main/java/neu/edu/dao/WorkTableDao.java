package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.WorkTable;

@Repository
public interface WorkTableDao extends JpaRepository<WorkTable, Integer>{

}
