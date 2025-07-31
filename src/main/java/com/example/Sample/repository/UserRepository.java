package com.example.Sample.repository;

import com.example.Sample.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findById(Long id);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
