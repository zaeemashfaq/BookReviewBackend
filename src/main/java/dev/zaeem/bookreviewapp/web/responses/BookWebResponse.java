package dev.zaeem.bookreviewapp.web.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookWebResponse extends WebRequestResponse {
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("description")
    private String description;
    @JsonProperty("cover_image")
    private String cover;
    @JsonProperty("overall_rating")
    private int overallRating;
}
