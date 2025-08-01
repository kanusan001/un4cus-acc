package com.example.Sample.service;
import com.example.Sample.UserDTO;
import com.example.Sample.repository.UserRepository;
import com.example.Sample.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.existsByUserName(userDTO.getUserName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }
        UserEntity userEntity = mapToEntity(userDTO);
        UserEntity savedEntity = userRepository.save(userEntity);
        return mapToDto(savedEntity);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(int id) {
        return userRepository.findById(id).map(this::mapToDto);
    }

    public UserDTO updateUser(int id, UserDTO userDTO) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        if (!user.getUserName().equals(userDTO.getUserName()) && userRepository.existsByUserName(userDTO.getUserName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        if (!user.getEmail().equals(userDTO.getEmail()) && userRepository.existsByEmail(userDTO.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRoles(UserEntity.role.valueOf(userDTO.getRole()));
        user.setStatus(UserEntity.status.valueOf(userDTO.getStatus()));
        UserEntity updatedEntity = userRepository.save(user);
        return mapToDto(updatedEntity);
    }

    public void deleteUser(int id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user.setStatus(UserEntity.status.INACTIVE);
        userRepository.save(user);
    }

    private UserDTO mapToDto(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setRole(userEntity.getRoles().name());
        userDTO.setStatus(userEntity.getStatus().name());
        return userDTO;
    }

    private UserEntity mapToEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setRoles(UserEntity.role.valueOf(userDTO.getRole()));
        userEntity.setStatus(UserEntity.status.valueOf(userDTO.getStatus()));
        return userEntity;
    }
}
