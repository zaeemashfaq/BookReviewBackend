package dev.zaeem.bookreviewapp.controllers;

import dev.zaeem.bookreviewapp.constant.ApiEndpoint;
import dev.zaeem.bookreviewapp.exceptions.DataNotFoundException;
import dev.zaeem.bookreviewapp.services.contract.IBookService;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import dev.zaeem.bookreviewapp.web.requests.AddBookRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private IBookService bookService;

    public BookController(IBookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping(
            value = ApiEndpoint.BOOKS,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity addAllBooks(@RequestBody List<AddBookRequest> addBookRequestList){
        ResponseEntity responseEntity;
        try {
            WebRequestResponse serviceResponse = bookService.addAllBooks(addBookRequestList);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }
        return responseEntity;
    }

    @RequestMapping(
            value = ApiEndpoint.BOOKS,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getAllBooks(){
        ResponseEntity responseEntity;
        try {
            List<WebRequestResponse> serviceResponse = bookService.getAllBooks();
            responseEntity = new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        }
        catch (DataNotFoundException dataNotFoundException){
            responseEntity = new ResponseEntity(dataNotFoundException.getLocalizedMessage(),HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }
        return responseEntity;
    }

    @RequestMapping(
            value = ApiEndpoint.SEARCH_BOOKS,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getAllBooksByTitleOrAuthor(@RequestParam("search_text") String searchText){
        ResponseEntity responseEntity;
        try {
            List<WebRequestResponse> serviceResponse = bookService.getAllBooksByTitleOrAuthor(searchText);
            responseEntity = new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        }
        catch (DataNotFoundException dataNotFoundException){
            responseEntity = new ResponseEntity(dataNotFoundException.getLocalizedMessage(),HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }
        return responseEntity;
    }

    @RequestMapping(
            value = ApiEndpoint.BOOK_BY_ID,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getBookById(@PathVariable("id") int id){
        ResponseEntity responseEntity;
        try {
            WebRequestResponse serviceResponse = bookService.getBookById(id);
            responseEntity = new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        }
        catch (DataNotFoundException dataNotFoundException){
            responseEntity = new ResponseEntity(dataNotFoundException.getLocalizedMessage(),HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }
        return responseEntity;
    }
}
