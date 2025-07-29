package com.example.Sample.repository;

import com.example.Sample.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    List<User> findByStatus(User.status status);

    Optional<User> findById(Long id);
}
