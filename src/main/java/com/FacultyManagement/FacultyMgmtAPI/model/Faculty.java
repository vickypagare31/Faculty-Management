package com.FacultyManagement.FacultyMgmtAPI.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="faculty")
@NoArgsConstructor
@AllArgsConstructor
//@JsonPropertyOrder({"id","name","email","department","gender","experience"})
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String department;
    private String gender;
    private int experience;

}
