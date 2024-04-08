package dev.zaeem.bookreviewapp.constant;

public interface ApiEndpoint {
    String BOOKS = "/books";
    String BOOKS_PAGED = "/books/paged";
    String SEARCH_BOOKS = "/books/search";
    String BOOK_BY_ID = "/books/{id}";
    String USER_REVIEWS = "/user-reviews";
    String USER_REVIEWS_BATCH = "/user-reviews/batch";
}
