package com.example.Sample;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;


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

    @JsonIgnore
    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    private String password;

    @NotNull
    private String role;

    @NotNull
    private String status;

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id ;
    }

    public @NotBlank @Size(min = 2, max = 30) @Pattern(regexp = "^[a-zA-Z]*$") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank @Size(min = 2, max = 30) @Pattern(regexp = "^[a-zA-Z]*$") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank @Size(min = 2, max = 30) @Pattern(regexp = "^[a-zA-Z]*$") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank @Size(min = 2, max = 30) @Pattern(regexp = "^[a-zA-Z]*$") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank @Size(min = 4, max = 20) String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank @Size(min = 4, max = 20) String userName) {
        this.userName = userName;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank @Size(min = 8) @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 8) @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$") String password) {
        this.password = password;
    }

    public @NotNull String getRole() {
        return role;
    }

    public void setRole(@NotNull String role) {
        this.role = role;
    }

    public @NotNull String getStatus() {
        return status;
    }

    public void setStatus(@NotNull String status) {
        this.status = status;
    }
}
