package dev.zaeem.bookreviewapp.web.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserReviewResponse extends WebRequestResponse {
    @JsonProperty("username")
    private String username;
    @JsonProperty("review_rating")
    private int reviewRating;
    @JsonProperty("review_title")
    private String reviewTitle;
    @JsonProperty("review_detail")
    private String reviewDetail;

}
