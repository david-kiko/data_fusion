package com.example.api.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "input", schema = "public")
public class Input {
    @Id
    @Column(name = "cid")
    private Long cid;
    
    @Column(name = "cname")
    private String cname;
} 