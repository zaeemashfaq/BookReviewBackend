package dev.zaeem.bookreviewapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReview extends BaseModel{
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_RATING")
    private int userRating;
    @Column(name = "USER_REVIEW_TITLE")
    private String userReviewTitle;
    @Column(name = "DETAILED_REVIEW",columnDefinition = "VARCHAR(500)")
    private String detailedReview;
    @ManyToOne
    private Book book;
    @Column(name = "CREATED_AT")
    private Timestamp createdAt;
}
