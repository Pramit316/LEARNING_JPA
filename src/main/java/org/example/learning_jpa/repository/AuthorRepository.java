package org.example.learning_jpa.repository;

import org.example.learning_jpa.models.Author;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAllByFirstName(String fn);

    //SELECT * FROM author WHERE first_name = ''
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    //SELECT * FROM author WHERE first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    //SELECT * FROM author WHERE first_name like 'al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);

    //SELECT * FROM author WHERE first_name like '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);

    //SELECT * FROM author WHERE first_name in ('pra', 'mit', 'god')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
