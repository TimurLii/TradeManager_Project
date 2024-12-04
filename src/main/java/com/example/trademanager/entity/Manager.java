package com.example.trademanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "managers")
@Data
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manager_name")
    private String managerName;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private Set<Client> clients;
}
