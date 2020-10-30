package edu.cetys.springlabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.cetys.springlabs.model.Token;
import edu.cetys.springlabs.repository.ProductRepository;
import edu.cetys.springlabs.repository.RegionRepository;
import edu.cetys.springlabs.repository.UserRepository;
import edu.cetys.springlabs.repository.WineryRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
		UserRepository.class, 
		WineryRepository.class, 
		RegionRepository.class,
		ProductRepository.class,
		Token.class})
public class WineTourPlannerRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WineTourPlannerRestApiApplication.class, args);
	}

}
