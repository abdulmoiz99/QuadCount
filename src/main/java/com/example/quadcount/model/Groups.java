package com.example.quadcount.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "`groups`")
@Data
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "groups_users",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Users> users;
}
