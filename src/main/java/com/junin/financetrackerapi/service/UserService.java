package com.junin.financetrackerapi.service;

import com.junin.financetrackerapi.dto.UserRequestDTO;
import com.junin.financetrackerapi.dto.UserResponseDTO;
import com.junin.financetrackerapi.entity.User;
import com.junin.financetrackerapi.exception.BusinessException;
import com.junin.financetrackerapi.exception.ResourceNotFoundException;
import com.junin.financetrackerapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO create(UserRequestDTO dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new BusinessException("Email already registered: " + dto.email());
        }

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());

        return UserResponseDTO.from(userRepository.save(user));
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDTO::from)
                .toList();
    }

    public UserResponseDTO findById(Long id) {
        return userRepository.findById(id)
                .map(UserResponseDTO::from)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));
    }

    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));

        if (!user.getEmail().equals(dto.email()) && userRepository.existsByEmail(dto.email())) {
            throw new BusinessException("Email already registered: " + dto.email());
        }

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());

        return UserResponseDTO.from(userRepository.save(user));
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User", id);
        }
        userRepository.deleteById(id);
    }
}