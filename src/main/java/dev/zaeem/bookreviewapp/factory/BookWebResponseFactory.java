package dev.zaeem.bookreviewapp.factory;

import dev.zaeem.bookreviewapp.models.Book;
import dev.zaeem.bookreviewapp.models.UserReview;
import dev.zaeem.bookreviewapp.web.WebRequestResponse;
import dev.zaeem.bookreviewapp.web.responses.BookWebResponse;
import dev.zaeem.bookreviewapp.web.responses.BookWebResponseSummary;
import dev.zaeem.bookreviewapp.web.responses.UserReviewResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookWebResponseFactory {
    public static List<UserReviewResponse> createBookUserReviewResponses(List<UserReview> userReviewList) {
        if (userReviewList == null) {
            return null;
        }
        List<UserReviewResponse> userReviewResponseList = new ArrayList<>();
        for (UserReview userReview : userReviewList) {
            UserReviewResponse userReviewResponse = new UserReviewResponse(userReview.getUserName(), (int) userReview.getUserRating(), userReview.getUserReviewTitle(), userReview.getDetailedReview());
            userReviewResponseList.add(userReviewResponse);
        }
        return userReviewResponseList;
    }

    public static BookWebResponse createBookWebResponse(Book book, List<UserReview> userReviews) {
        List<UserReviewResponse> userReviewResponseList = createBookUserReviewResponses(userReviews);
        BookWebResponse bookWebResponse = new BookWebResponse((int) book.getId(), book.getTitle(), book.getAuthor(), book.getDescription(), book.getCover(), book.getRoundedRating(), userReviewResponseList);
        return bookWebResponse;
    }

    public static List<WebRequestResponse> createBookWebResponseSummaryList(List<Book> bookList) {
        List<WebRequestResponse> bookWebResponseSummaryList = new ArrayList<>();
        for (Book book : bookList) {
            BookWebResponseSummary bookWebResponse = new BookWebResponseSummary((int) book.getId(), book.getTitle(), book.getAuthor(), book.getCover(), book.getRoundedRating());
            bookWebResponseSummaryList.add(bookWebResponse);
        }
        return bookWebResponseSummaryList;
    }
}
