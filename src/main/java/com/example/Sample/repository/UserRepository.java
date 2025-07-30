package com.example.Sample.repository;

import com.example.Sample.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    List<UserEntity> findByStatus(UserEntity.status status);

    Optional<UserEntity> findById(Long id);
}
