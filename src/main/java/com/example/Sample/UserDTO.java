package com.example.Sample;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDTO {
    private int id;

    @NotBlank
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String lastName;

    @NotBlank
    @Size(min = 4, max = 20)
    private String userName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    private String password;

    @NotNull
    private String role;

    @NotNull
    private String status;
}
