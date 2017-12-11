package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Idea;

@Repository
public interface IdeaDao extends JpaRepository<Idea, Integer>{

}
