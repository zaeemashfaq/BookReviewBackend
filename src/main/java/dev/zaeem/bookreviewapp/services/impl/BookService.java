package dev.zaeem.bookreviewapp.services.impl;

import dev.zaeem.bookreviewapp.exceptions.DataNotFoundException;
import dev.zaeem.bookreviewapp.factory.BookWebResponseFactory;
import dev.zaeem.bookreviewapp.models.Book;
import dev.zaeem.bookreviewapp.models.UserReview;
import dev.zaeem.bookreviewapp.repository.BookRepository;
import dev.zaeem.bookreviewapp.services.contract.IBookService;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import dev.zaeem.bookreviewapp.web.requests.AddBookRequest;
import dev.zaeem.bookreviewapp.web.requests.AddUserReviewRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private BookRepository bookRepository;
    private UserReviewService userReviewService;
    private BookWebResponseFactory bookWebResponseFactory;
    public BookService(BookRepository bookRepository, @Lazy UserReviewService userReviewService, BookWebResponseFactory bookWebResponseFactory){
        this.bookRepository = bookRepository;
        this.userReviewService = userReviewService;
        this.bookWebResponseFactory = bookWebResponseFactory;
    }
    @Override
    public List<WebRequestResponse> getAllBooks() throws DataNotFoundException {
        List<Book> bookList = bookRepository.findAll();
        List<WebRequestResponse> bookWebResponseSummaryList = bookWebResponseFactory.createBookWebResponseSummaryList(bookList);
        return bookWebResponseSummaryList;
    }

    @Override
    public List<WebRequestResponse> getAllBooksByTitleOrAuthor(String searchText) throws DataNotFoundException {
        Optional<List<Book>> bookListOptional = bookRepository.findAllByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(searchText,searchText);
        List<Book> bookList = null;
        if(bookListOptional.isEmpty()){
            throw new DataNotFoundException("No books found with the given search text");
        }
        else{
            bookList = bookListOptional.get();
        }
        List<WebRequestResponse> bookWebResponseSummaryList = bookWebResponseFactory.createBookWebResponseSummaryList(bookList);
        return bookWebResponseSummaryList;
    }

    @Override
    public WebRequestResponse getBookById(int id) throws DataNotFoundException {
        Book book = bookRepository.findById(id);
        List<UserReview> userReviews = userReviewService.getUserReviewsByBook(book);
        WebRequestResponse bookWebResponse = bookWebResponseFactory.createBookWebResponse(book,userReviews);
        return bookWebResponse;
    }

    @Override
    public Book getBookById(AddUserReviewRequest userReviewRequest) throws DataNotFoundException {
        Book book = bookRepository.findById(userReviewRequest.getBookId());
        return book;
    }

    @Override
    public WebRequestResponse addAllBooks(List<AddBookRequest> addBookRequestList) {
        List<Book> bookList = Book.from(addBookRequestList);
        for(Book book: bookList){
            bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void UpdateBookRating(Book book, int userRating){
        int ratingCount = book.getRatingCount();
        book.setRatingCount(ratingCount+1);
        int roundedRating = book.getRoundedRating();
        double exactRating = book.getExactRating();
        double newExactRating = (exactRating*ratingCount + userRating)/(ratingCount+1);
        int newRoundedRating = (int)Math.round(newExactRating);
        book.setRoundedRating(newRoundedRating);
        book.setExactRating(newExactRating);
        bookRepository.save(book);
    }
}
