package org.gfg.dbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {org.gfg.dbs.repository.MyPersonRepository.class})
public class DbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbsApplication.class, args);
	}

}
