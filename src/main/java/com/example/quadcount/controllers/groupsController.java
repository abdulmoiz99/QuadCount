package com.example.quadcount.controllers;

import com.example.quadcount.dto.NewGroupDTO;
import com.example.quadcount.model.Groups;
import com.example.quadcount.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.quadcount.repository.groupRepository;
import com.example.quadcount.repository.userRepository;

import java.util.List;


@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "http://localhost:5173")
public class groupsController {

    @Autowired
    private  groupRepository groupRepository;

    @Autowired
    private  userRepository userRepository;

    @PostMapping
    public ResponseEntity<String> newGroup(@RequestBody NewGroupDTO newGroup) {
        Groups group = new Groups();
        group.setName(newGroup.getGroupName());

        List<Users> users = userRepository.findAllById(newGroup.getUserId()).stream().toList();

        group.setUsers(users);

        groupRepository.save(group);

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
