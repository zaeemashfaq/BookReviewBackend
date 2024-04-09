import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import dev.zaeem.bookreviewapp.services.impl.UserReviewService;
import static org.mockito.Mockito.mock;
import dev.zaeem.bookreviewapp.services.contract.IUserReviewService;
import dev.zaeem.bookreviewapp.repository.UserReviewRepository;
import dev.zaeem.bookreviewapp.services.impl.BookService;
import dev.zaeem.bookreviewapp.web.requests.AddUserReviewRequest;

public class UserReviewServiceTest {
    IUserReviewService userReviewService;
    public UserReviewServiceTest(){
        UserReviewRepository userReviewRepository = mock(UserReviewRepository.class);
        BookService bookService = mock(BookService.class);
        this.userReviewService = new UserReviewService(userReviewRepository,bookService);
    }
//    @Test
    void testAddReviewThrowsExceptionWhenRatingIsNegative(){
        AddUserReviewRequest invalidRequest = new AddUserReviewRequest();
        invalidRequest.setReviewer("Ramesh");
        invalidRequest.setRating(-1);
        invalidRequest.setReviewDetail("Review Detail");
        invalidRequest.setReviewTitle("Review Title");
        invalidRequest.setBookId(2);
        assertThrows(IllegalArgumentException.class,()->{
            userReviewService.addReview(invalidRequest);
        });
    }
}
