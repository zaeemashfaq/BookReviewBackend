package dev.zaeem.bookreviewapp.models;

import dev.zaeem.bookreviewapp.web.requests.AddUserReviewRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
    @CreationTimestamp
    @Column(name = "CREATED_AT",nullable = false, updatable = false)
    private Timestamp createdAt;

    public static  UserReview from(AddUserReviewRequest userReviewRequest, Book book){
        UserReview userReview = new UserReview();
        userReview.setUserName(userReviewRequest.getReviewer());
        userReview.setUserRating(userReviewRequest.getRating());
        userReview.setUserReviewTitle(userReviewRequest.getReviewTitle());
        userReview.setDetailedReview(userReviewRequest.getReviewDetail());
        userReview.setBook(book);
        return userReview;
    }
}
