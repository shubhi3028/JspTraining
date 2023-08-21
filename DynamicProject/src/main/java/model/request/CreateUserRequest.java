package model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
