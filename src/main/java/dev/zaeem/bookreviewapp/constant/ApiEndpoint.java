package dev.zaeem.bookreviewapp.constant;

public interface ApiEndpoint {
    String BOOKS = "/api/books";
    String BOOKS_PAGED = "/api/books/paged";
    String SEARCH_BOOKS = "/api/books/search";
    String BOOK_BY_ID = "/api/books/{id}";
    String USER_REVIEWS = "/api/user-reviews";
    String USER_REVIEWS_BATCH = "/api/user-reviews/batch";
}
