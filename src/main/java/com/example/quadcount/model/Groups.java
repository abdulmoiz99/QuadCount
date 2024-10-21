package com.example.quadcount.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "`groups`")
@Data
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
