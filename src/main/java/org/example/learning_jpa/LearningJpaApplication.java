package org.example.learning_jpa;

import org.example.learning_jpa.models.Author;
import org.example.learning_jpa.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository repository
    ) {
        return args -> {
            var author = Author.builder()
                    .firstName("pramit")
                    .lastName("bhattarai")
                    .age(23)
                    .email("primeshipbas@gmail.com")
                    .build();
            repository.save(author);
        };
    }
}
