package dev.zaeem.bookreviewapp.services.impl;

import dev.zaeem.bookreviewapp.exceptions.DataNotFoundException;
import dev.zaeem.bookreviewapp.factory.BookWebResponseFactory;
import dev.zaeem.bookreviewapp.models.Book;
import dev.zaeem.bookreviewapp.repository.BookRepository;
import dev.zaeem.bookreviewapp.services.contract.IBookService;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import dev.zaeem.bookreviewapp.web.requests.AddBookRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    private BookRepository bookRepository;
    private BookWebResponseFactory bookWebResponseFactory;
    public BookService(BookRepository bookRepository, BookWebResponseFactory bookWebResponseFactory){
        this.bookRepository = bookRepository;
        this.bookWebResponseFactory = bookWebResponseFactory;
    }
    @Override
    public List<WebRequestResponse> getAllBooks() throws DataNotFoundException {
        List<Book> bookList = bookRepository.findAll();
        List<WebRequestResponse> bookWebResponseList = bookWebResponseFactory.createBookWebResponseList(bookList);
        return bookWebResponseList;
    }

    @Override
    public WebRequestResponse getBookById(int id) throws DataNotFoundException {
        Book book = bookRepository.findById(id);
        WebRequestResponse bookWebResponse = bookWebResponseFactory.createBookWebResponse(book);
        return bookWebResponse;
    }

    @Override
    public WebRequestResponse addAllBooks(List<AddBookRequest> addBookRequestList) {
        List<Book> bookList = Book.from(addBookRequestList);
        for(Book book: bookList){
            bookRepository.save(book);
        }
        return null;
    }
}
