package com.junin.financetrackerapi.controller;

import com.junin.financetrackerapi.dto.ApiResponse;
import com.junin.financetrackerapi.dto.UserRequestDTO;
import com.junin.financetrackerapi.dto.UserResponseDTO;
import com.junin.financetrackerapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> findAll() {
        List<UserResponseDTO> users = userService.findAll();

        ApiResponse<List<UserResponseDTO>> response =
                new ApiResponse<>("Usuários listados com sucesso", users);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> findById(@PathVariable Long id) {
        UserResponseDTO user = userService.findById(id);

        ApiResponse<UserResponseDTO> response =
                new ApiResponse<>("Usuário encontrado com sucesso", user);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> create(
            @Valid @RequestBody UserRequestDTO dto
    ) {
        UserResponseDTO createdUser = userService.create(dto);

        ApiResponse<UserResponseDTO> response =
                new ApiResponse<>("Usuário criado com sucesso", createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> update(
            @PathVariable Long id,
            @Valid @RequestBody UserRequestDTO dto
    ) {
        UserResponseDTO updatedUser = userService.update(id, dto);

        ApiResponse<UserResponseDTO> response =
                new ApiResponse<>("Usuário atualizado com sucesso", updatedUser);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        userService.delete(id);

        ApiResponse<Void> response =
                new ApiResponse<>("Usuário removido com sucesso", null);

        return ResponseEntity.ok(response);
    }
}