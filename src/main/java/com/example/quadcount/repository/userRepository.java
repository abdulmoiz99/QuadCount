package com.example.quadcount.repository;

import com.example.quadcount.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<Users, Integer> {
}
