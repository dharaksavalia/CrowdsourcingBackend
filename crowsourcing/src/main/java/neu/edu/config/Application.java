package neu.edu.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"neu.edu.controller","neu.edu.service"})
@EnableJpaRepositories("neu.edu.dao")
@EntityScan("neu.edu.entity")
public class Application implements CommandLineRunner{
	
	@Autowired
	private DataSource dataSource;
	
	public static void main(String...args){
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		  System.out.println("DATASOURCE = " + dataSource);
		
	}
	

}
