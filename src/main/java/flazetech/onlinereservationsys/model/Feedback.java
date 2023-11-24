package flazetech.onlinereservationsys.model;

import flazetech.onlinereservationsys.dto.FeedbackDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "feedback")
public class Feedback {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String feedback;

    public Feedback(FeedbackDTO feedbackDTO) {
        //
        BeanUtils.copyProperties(feedbackDTO, this);
    }

    public FeedbackDTO toDomain() {
        //
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        BeanUtils.copyProperties(this, feedbackDTO);
        return feedbackDTO;
    }

    public static Feedback fromDomain(FeedbackDTO feedbackDTO) {
        //
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(feedbackDTO, feedback);
        return feedback;
    }
}
