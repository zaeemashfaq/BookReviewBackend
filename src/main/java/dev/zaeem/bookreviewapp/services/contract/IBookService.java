package dev.zaeem.bookreviewapp.services.contract;

import dev.zaeem.bookreviewapp.exceptions.DataNotFoundException;
import dev.zaeem.bookreviewapp.models.Book;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import dev.zaeem.bookreviewapp.web.requests.AddBookRequest;
import dev.zaeem.bookreviewapp.web.requests.AddUserReviewRequest;

import java.util.List;

public interface IBookService {
    List<WebRequestResponse> getAllBooks() throws DataNotFoundException;
    List<WebRequestResponse> getAllBooksPaged(int pageNumber,int pageSize) throws DataNotFoundException;
    List<WebRequestResponse> getAllBooksByTitleOrAuthor(String searchText) throws DataNotFoundException;
    WebRequestResponse getBookById(int id) throws DataNotFoundException;

    Book getBookById(AddUserReviewRequest userReviewRequest) throws DataNotFoundException;

    WebRequestResponse addAllBooks(List<AddBookRequest> addBookRequestList);

    void UpdateBookRating(Book book, int userRating);
}
