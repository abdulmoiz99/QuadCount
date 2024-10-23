package com.example.quadcount.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewGroupDTO {
    private String groupName;
    private List<Long> userId;
}
