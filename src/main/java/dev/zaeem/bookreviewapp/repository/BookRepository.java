package dev.zaeem.bookreviewapp.repository;

import dev.zaeem.bookreviewapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();

    <S extends Book>S save (S Entity);

    Book findById(long id);
}
