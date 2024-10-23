package com.example.quadcount.controller;

import com.example.quadcount.dto.NewGroupDTO;
import com.example.quadcount.model.Groups;
import com.example.quadcount.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.quadcount.repository.GroupRepository;
import com.example.quadcount.repository.UserRepository;

import java.util.List;


@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "http://localhost:5173")
public class GroupsController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private  UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> newGroup(@RequestBody NewGroupDTO newGroup) {
        Groups group = new Groups();
        group.setName(newGroup.getGroupName());

        //List<User> users = userRepository.findAllById(newGroup.getUserId()).stream().toList();

       List<User> users =   userRepository.findAllById(newGroup.getUserId()).stream().toList();

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
