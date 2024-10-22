package com.example.quadcount.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinTable(name = "group_members",
            inverseJoinColumns = @JoinColumn(name = "group_id"),
            joinColumns = @JoinColumn(name = "member_id"))
    private Groups group;
}
