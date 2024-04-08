package dev.zaeem.bookreviewapp.services.contract;

import dev.zaeem.bookreviewapp.exceptions.DataNotFoundException;
import dev.zaeem.bookreviewapp.models.Book;
import dev.zaeem.bookreviewapp.models.UserReview;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import dev.zaeem.bookreviewapp.web.requests.AddUserReviewRequest;

import java.util.List;

public interface IUserReviewService {
    WebRequestResponse addReview(AddUserReviewRequest userReviewRequest) throws DataNotFoundException, IllegalArgumentException;
    WebRequestResponse addReview(List<AddUserReviewRequest> userReviewRequestList) throws DataNotFoundException, IllegalArgumentException;

    List<UserReview> getUserReviewsByBook(Book book);
}
