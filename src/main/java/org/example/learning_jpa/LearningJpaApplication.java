package org.example.learning_jpa;

import org.example.learning_jpa.models.Author;
import org.example.learning_jpa.models.Video;
import org.example.learning_jpa.repository.AuthorRepository;
import org.example.learning_jpa.repository.VideoRepository;
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
            AuthorRepository repository,
            VideoRepository videoRepository
    ) {
        return args -> {
//            var author = Author.builder()
//                    .firstName("pramit")
//                    .lastName("bhattarai")
//                    .age(23)
//                    .email("primeshipbas@gmail.com")
//                    .build();
//            repository.save(author);
            var video = Video.builder()
                    .name("abc")
                    .length(5)
                    .build();

            videoRepository.save(video);
        };
    }
}
