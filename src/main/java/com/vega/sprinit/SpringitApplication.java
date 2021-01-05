package com.vega.sprinit;

import com.vega.sprinit.config.SpringitProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication //comprise or made up of other anotation
public class SpringitApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);


	}

}
