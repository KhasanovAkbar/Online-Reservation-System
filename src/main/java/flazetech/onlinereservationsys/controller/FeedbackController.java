package flazetech.onlinereservationsys.controller;

import flazetech.onlinereservationsys.dto.FeedbackDTO;
import flazetech.onlinereservationsys.helper.APIResponse;
import flazetech.onlinereservationsys.helper.ResponseBuilder;
import flazetech.onlinereservationsys.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    //
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit")
    public ResponseEntity<APIResponse> submitFeedback(FeedbackDTO feedbackDTO) {
        //
        feedbackService.saveFeedback(feedbackDTO);
        return ResponseBuilder.buildOK("Feedback successfully send", null, HttpStatus.OK);
    }
}
