package dev.zaeem.bookreviewapp.services.contract;

import dev.zaeem.bookreviewapp.exceptions.DataNotFoundException;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import dev.zaeem.bookreviewapp.web.requests.AddBookRequest;

import java.util.List;

public interface IBookService {
    List<WebRequestResponse> getAllBooks() throws DataNotFoundException;
    WebRequestResponse addAllBooks(List<AddBookRequest> addBookRequestList);
}
