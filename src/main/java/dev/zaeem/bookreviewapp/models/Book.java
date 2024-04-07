package dev.zaeem.bookreviewapp.models;

import dev.zaeem.bookreviewapp.web.requests.AddBookRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book extends BaseModel{
    @Column(name = "TITLE")
    private String title;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "DESCRIPTION",columnDefinition = "VARCHAR(1000)")
    private String description;
    @Column(name = "COVER")
    private String cover;
    @Column(name = "ROUNDED_RATING")
    private int roundedRating;
    @Column(name = "EXACT_RATING")
    private double exactRating;
    private int ratingCount;
    @CreationTimestamp
    @Column(name = "CREATED_AT",nullable = false, updatable = false)
    private Timestamp createdAt;
    public static Book from(AddBookRequest addBookRequest){
        Book book = new Book();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setDescription(addBookRequest.getDescription());
        book.setCover(addBookRequest.getCover());
        book.setRoundedRating(0);
        book.setExactRating(0.0);
        book.setRatingCount(0);
        return book;
    }
    public static List<Book> from(List<AddBookRequest> addBookRequests){
        List<Book> bookList = new ArrayList<>();
        for(AddBookRequest addBookRequest : addBookRequests){
            bookList.add(Book.from(addBookRequest));
        }
        return bookList;
    }
}
