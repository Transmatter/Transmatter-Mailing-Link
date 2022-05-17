package transmatter.project.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    Long id;
    String username;
    String email;
    String firstname;
    String lastname;
    String imageProfile;
    String phoneNo;
}
