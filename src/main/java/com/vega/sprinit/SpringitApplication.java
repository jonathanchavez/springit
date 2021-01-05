package com.vega.sprinit;

import com.vega.sprinit.config.SpringitProperties;
import com.vega.sprinit.domain.Comment;
import com.vega.sprinit.domain.Link;
import com.vega.sprinit.repository.CommentRepository;
import com.vega.sprinit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication //comprise or made up of other anotation
@EnableJpaAuditing
public class SpringitApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);


	}

	@Bean  //need @bean to be picked up as a bean and resigter as a bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository	) {
		return args -> {
			Link link = new Link("Getting Started with spring boot 2", "www.google.com");
			linkRepository.save(link);

			Comment comment = new Comment("THis spring 2 link", link);
			commentRepository.save(comment);

			//need to tell the other side what is going on
			link.addComment(comment);


////			prints title out to console
//			Link firstLink = linkRepository.findByTitle("getting starter");
//			System.out.println(firstLink.getTitle());

		};
	}

}
