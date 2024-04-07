package dev.zaeem.bookreviewapp.controllers;

import dev.zaeem.bookreviewapp.constant.ApiEndpoint;
import dev.zaeem.bookreviewapp.services.contract.IUserReviewService;
import dev.zaeem.bookreviewapp.web.requests.AddUserReviewRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserReviewController {
    private IUserReviewService userReviewService;
    public UserReviewController(IUserReviewService userReviewService){
        this.userReviewService = userReviewService;
    }

    @RequestMapping(
            value = ApiEndpoint.USER_REVIEWS,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity addUserReview(@RequestBody AddUserReviewRequest userReviewRequest){
        ResponseEntity responseEntity;
        try {
            userReviewService.addReview(userReviewRequest);
            responseEntity = new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }
        return responseEntity;
    }

    @RequestMapping(
            value = ApiEndpoint.USER_REVIEWS_BATCH,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity addAllUserReview(@RequestBody List<AddUserReviewRequest> userReviewRequestList){
        ResponseEntity responseEntity;
        try {
            userReviewService.addReview(userReviewRequestList);
            responseEntity = new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }
        return responseEntity;
    }
}
