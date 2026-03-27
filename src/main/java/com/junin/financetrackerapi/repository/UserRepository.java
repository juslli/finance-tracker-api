package com.junin.financetrackerapi.repository;

import com.junin.financetrackerapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
