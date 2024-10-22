package com.example.quadcount.repository;

import com.example.quadcount.model.Members;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface membersRepository extends CrudRepository<Members, Integer> {
    List<Members> findAll();
}
