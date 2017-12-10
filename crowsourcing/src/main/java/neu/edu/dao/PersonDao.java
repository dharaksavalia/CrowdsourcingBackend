package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer>{
	List<Person>findByFirstNameAndLastName(String firstName,String LastName);

}
