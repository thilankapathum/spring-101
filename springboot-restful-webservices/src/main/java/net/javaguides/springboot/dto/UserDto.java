package net.javaguides.springboot.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    //-- ! DO NOT USE SENSITIVE INFORMATION IN DTOs

    private Long id;

    @NotEmpty(message = "User's First Name should not be empty!")   //-- Should not be Null or Empty (Validator)
    private String firstName;

    @NotEmpty(message = "User's Last Name should not be empty!")
    private String lastName;

    @NotEmpty(message = "User's Email should not be empty!")
    @Email(message = "Email address should be valid!")      //-- Email should be on proper format (Validator)
    private String email;
}
