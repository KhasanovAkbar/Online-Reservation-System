package flazetech.onlinereservationsys.service;

import flazetech.onlinereservationsys.dto.FeedbackDTO;
import flazetech.onlinereservationsys.model.Feedback;

public interface FeedbackService {
    //
    void saveFeedback(FeedbackDTO feedbackDTO);
}
