package org.example.learning_jpa;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
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
            for(int i = 0; i<50; i++){
                Faker faker = new Faker();
                var author = Author.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .age(faker.number().numberBetween(19,59))
                        .email("test" + i + "@gmail.com")
                        .build();
            }

//            update author with ID = 1

            var author = Author.builder()
                    .id(1)
                    .firstName("pramit")
                    .lastName("Bhattarai")
                    .age(23)
                    .email("pramit@gmail.com")
                    .build();
//            repository.save(author);
//            repository.updateAuthor(22, 1);

//            repository.updateAllAuthor(100);

            repository.updateByNamedQuery(90);
            repository.findByNamedQuery(60)
                    .forEach(System.out::println);


            /*var video = Video.builder()
                    .name("abc")
                    .length(5)
                    .build();

            videoRepository.save(video);*/
        };
    }
}
