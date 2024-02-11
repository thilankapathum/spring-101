package net.javaguides.springboot.dto;


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
    private String firstName;
    private String lastName;
    private String email;
}
