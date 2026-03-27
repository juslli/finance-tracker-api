package com.junin.financetrackerapi.service;

import com.junin.financetrackerapi.entity.User;
import com.junin.financetrackerapi.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User update(Long id, User userUpdated) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userUpdated.getName());
                    user.setEmail(userUpdated.getEmail());
                    user.setMonthlyIncome(userUpdated.getMonthlyIncome());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
