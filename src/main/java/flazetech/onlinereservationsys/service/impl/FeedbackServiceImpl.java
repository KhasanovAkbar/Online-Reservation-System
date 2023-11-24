package flazetech.onlinereservationsys.service.impl;

import flazetech.onlinereservationsys.dto.FeedbackDTO;
import flazetech.onlinereservationsys.model.Feedback;
import flazetech.onlinereservationsys.repository.FeedbackRepository;
import flazetech.onlinereservationsys.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    //
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void saveFeedback(FeedbackDTO feedbackDTO) {
        //
        Feedback feedback = Feedback.fromDomain(feedbackDTO);
        feedbackRepository.save(feedback);
    }
}
