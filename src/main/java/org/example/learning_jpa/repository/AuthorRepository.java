package org.example.learning_jpa.repository;

import jakarta.transaction.Transactional;
import org.example.learning_jpa.models.Author;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    //update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("UPDATE Author a set a.age = :age")
    int updateAllAuthor(int age);

    List<Author> findAllByFirstName(String fn);

    //SELECT * FROM author WHERE first_name = ''
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    //SELECT * FROM author WHERE last_name = ''
    List<Author> findAllByLastNameIgnoreCase(String fn);

    //SELECT * FROM author WHERE first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    //SELECT * FROM author WHERE first_name like 'al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);

    //SELECT * FROM author WHERE first_name like '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);

    //SELECT * FROM author WHERE first_name in ('pra', 'mit', 'god')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
