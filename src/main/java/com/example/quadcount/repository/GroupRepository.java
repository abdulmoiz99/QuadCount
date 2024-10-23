package com.example.quadcount.repository;

import com.example.quadcount.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Groups,Integer > {
    List<Groups> findAll();
}
