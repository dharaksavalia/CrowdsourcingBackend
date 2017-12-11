package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Startup;
import neu.edu.entity.User;

@Repository
public interface StartupDao extends JpaRepository<Startup, Integer> {

}
