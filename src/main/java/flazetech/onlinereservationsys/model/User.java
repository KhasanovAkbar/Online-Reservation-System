package flazetech.onlinereservationsys.model;

import flazetech.onlinereservationsys.dto.UserDTO;
import flazetech.onlinereservationsys.model.enums.ActivationStatus;
import flazetech.onlinereservationsys.model.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public User(UserDTO userDTO) {
        //
        BeanUtils.copyProperties(userDTO, this);
    }

    public UserDTO toDomain(){
        //
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(this, userDTO);
        return userDTO;
    }

    public static User fromDomain(UserDTO userDTO){
        //
        User user = new User();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        user.setCreatedDate(dateFormat.format(date));
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }

}
