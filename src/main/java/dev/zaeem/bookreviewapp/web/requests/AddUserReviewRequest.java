package dev.zaeem.bookreviewapp.web.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import lombok.Getter;

@Getter
public class AddUserReviewRequest extends WebRequestResponse {
    @JsonProperty("book_id")
    private int bookId;
    @JsonProperty("rating")
    private int rating;
    @JsonProperty("review_title")
    private String reviewTitle;
    @JsonProperty("review_detail")
    private String reviewDetail;
    @JsonProperty("reviewer")
    private String reviewer;
}
