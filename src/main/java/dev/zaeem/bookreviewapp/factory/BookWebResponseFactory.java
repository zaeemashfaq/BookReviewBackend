package dev.zaeem.bookreviewapp.factory;

import dev.zaeem.bookreviewapp.models.Book;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import dev.zaeem.bookreviewapp.web.responses.BookWebResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookWebResponseFactory {
    public static BookWebResponse createBookWebResponse(Book book){
        BookWebResponse bookWebResponse = new BookWebResponse(book.getTitle(),book.getAuthor(),book.getDescription(),book.getCover(),book.getOverallRating());
        return bookWebResponse;
    }
    public static List<WebRequestResponse> createBookWebResponseList(List<Book> bookList){
        List<WebRequestResponse> bookWebResponseList = new ArrayList<>();
        for(Book book: bookList){
            BookWebResponse bookWebResponse = createBookWebResponse(book);
            bookWebResponseList.add(bookWebResponse);
        }
        return bookWebResponseList;
    }
}
