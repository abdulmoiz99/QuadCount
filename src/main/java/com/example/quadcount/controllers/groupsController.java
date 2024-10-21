package com.example.quadcount.controllers;

import com.example.quadcount.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.quadcount.repository.groupRepository;

import java.util.List;


@RestController
@RequestMapping("/groups")
public class groupsController {

    @Autowired
    private  groupRepository groupRepository;

    @PostMapping
    public ResponseEntity<String> newGroup(@RequestBody Groups newGroup) {
        groupRepository.save(newGroup);
        return new ResponseEntity<>("Group added successfully!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Groups>> getBooks() {
        List<Groups> groups = groupRepository.findAll();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        groupRepository.deleteById(id);
        return new ResponseEntity<>("Group deleted successfully", HttpStatus.OK);
    }
}
