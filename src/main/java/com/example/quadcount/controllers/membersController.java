package com.example.quadcount.controllers;

import com.example.quadcount.dto.MemberDTO;
import com.example.quadcount.model.Groups;
import com.example.quadcount.model.Members;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.quadcount.repository.membersRepository;
import com.example.quadcount.repository.groupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class membersController {

    @Autowired
    private membersRepository membersRepository;

    @Autowired
    private groupRepository groupRepository;

    @PostMapping
    public ResponseEntity<String> newMember(@RequestBody MemberDTO memberDTO) {

        Members member = new Members();
        Groups group = groupRepository.findById(memberDTO.getGroupId()).orElse(null);
        member.setGroup(group);
        membersRepository.save(member);
        return new ResponseEntity<>("Member added successfully!", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Members>> getMembers() {
        List<Members> members = membersRepository.findAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
}
