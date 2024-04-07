package dev.zaeem.bookreviewapp.services.impl;

import dev.zaeem.bookreviewapp.exceptions.DataNotFoundException;
import dev.zaeem.bookreviewapp.models.Book;
import dev.zaeem.bookreviewapp.models.UserReview;
import dev.zaeem.bookreviewapp.repository.UserReviewRepository;
import dev.zaeem.bookreviewapp.services.contract.IUserReviewService;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import dev.zaeem.bookreviewapp.web.requests.AddUserReviewRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserReviewService implements IUserReviewService {
    private UserReviewRepository userReviewRepository;
    private BookService bookService;
    public UserReviewService(UserReviewRepository userReviewRepository, BookService bookService) {
        this.userReviewRepository = userReviewRepository;
        this.bookService = bookService;
    }
    @Override
    public WebRequestResponse addReview(AddUserReviewRequest userReviewRequest) throws DataNotFoundException {
        Book reviewedBook = bookService.getBookById(userReviewRequest);
        UserReview userReview = UserReview.from(userReviewRequest,reviewedBook);
        userReviewRepository.save(userReview);
        bookService.UpdateBookRating(reviewedBook,userReview.getUserRating());
        return null;
    }

    @Override
    public WebRequestResponse addReview(List<AddUserReviewRequest> userReviewRequestList) throws DataNotFoundException {
        for (AddUserReviewRequest userReviewRequest: userReviewRequestList){
            addReview(userReviewRequest);
        }
        return null;
    }

    @Override
    public List<UserReview> getUserReviewsByBook(Book book){
        Optional<List<UserReview>> userReviewsOptional = userReviewRepository.findAllByBookOrderByCreatedAtDesc(book);
        List<UserReview> userReviews = null;
        if(userReviewsOptional.isPresent()){
            userReviews = userReviewsOptional.get();
        }
        return userReviews;
    }
}