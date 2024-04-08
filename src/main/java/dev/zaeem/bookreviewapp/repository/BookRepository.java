package dev.zaeem.bookreviewapp.repository;

import dev.zaeem.bookreviewapp.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();
    Page<Book> findAll(Pageable pageable);

    <S extends Book>S save (S Entity);

    Book findById(long id);

    Optional<List<Book>> findAllByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String searchTextTitle, String searchTextAuthor);
}
