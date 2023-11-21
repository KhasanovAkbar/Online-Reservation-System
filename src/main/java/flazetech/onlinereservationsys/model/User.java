package flazetech.onlinereservationsys.model;

import flazetech.onlinereservationsys.model.enums.ActivationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    private String createdDate;

    private String longinDate;

    @Column(name = "activation_link_expiration")
    private LocalDateTime activationLinkExpiration;

    @Enumerated(EnumType.STRING)
    private ActivationStatus activationStatus; // Enum field for activation status

}
