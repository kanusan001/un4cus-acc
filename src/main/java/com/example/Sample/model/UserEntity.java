package com.example.Sample.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")})
@NoArgsConstructor
@Data
public class UserEntity {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name can only contain letters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Last name can only contain letters")
    private String lastName;

    @NotBlank(message = "Username is required")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String userName;


    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).+$",
            message = "Password must contain at least one uppercase letter, one number, and one special character"
    )
    private String password;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private role roles;


    @CreationTimestamp
    private LocalDate createdDate;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private status status;

    public enum role{ADMIN,USER,GUEST};
    public enum status{ACTIVE,INACTIVE};

    public @NotBlank(message = "First name is required") @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters") @Pattern(regexp = "^[A-Za-z]+$", message = "First name can only contain letters") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First name is required") @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters") @Pattern(regexp = "^[A-Za-z]+$", message = "First name can only contain letters") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Last name is required") @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters") @Pattern(regexp = "^[A-Za-z]+$", message = "Last name can only contain letters") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Last name is required") @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters") @Pattern(regexp = "^[A-Za-z]+$", message = "Last name can only contain letters") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Username is required") @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "Username is required") @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters") String userName) {
        this.userName = userName;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters") @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).+$",
            message = "Password must contain at least one uppercase letter, one number, and one special character"
    ) String getPassword() {
        return password;
    }


    public void setPassword(@NotBlank(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters") @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).+$",
            message = "Password must contain at least one uppercase letter, one number, and one special character"
    ) String password) {
        this.password = password;
    }

    public role getRoles() {
        return roles;
    }

    public void setRoles(role roles) {
        this.roles = roles;
    }

    public UserEntity.status getStatus() {
        return status;
    }

    public void setStatus(UserEntity.status status) {
        this.status = status;
    }
}
