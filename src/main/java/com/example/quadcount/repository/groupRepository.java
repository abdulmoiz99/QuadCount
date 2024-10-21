package com.example.quadcount.repository;

import com.example.quadcount.model.Groups;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface groupRepository extends CrudRepository<Groups,Integer > {
    List<Groups> findAll();
}
