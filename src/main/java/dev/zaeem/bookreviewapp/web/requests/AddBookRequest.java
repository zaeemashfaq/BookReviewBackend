package dev.zaeem.bookreviewapp.web.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import lombok.Getter;

@Getter
public class AddBookRequest extends WebRequestResponse {
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("description")
    private String description;
    @JsonProperty("cover")
    private String cover;
    @JsonProperty("overall_rating")
    private int overallRating;
}
