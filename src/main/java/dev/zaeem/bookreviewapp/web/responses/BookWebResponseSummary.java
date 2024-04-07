package dev.zaeem.bookreviewapp.web.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookWebResponseSummary extends WebRequestResponse {
    @JsonProperty("id")
    int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("cover_image")
    private String cover;
    @JsonProperty("overall_rating")
    private int overallRating;
//    @JsonProperty("user_reviews")
//    private List<UserReviewResponse> userReviews;
}
