package dev.zaeem.bookreviewapp.repository;

import dev.zaeem.bookreviewapp.models.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
    List<UserReview> findAll();

    <S extends UserReview>S save (S Entity);
}
