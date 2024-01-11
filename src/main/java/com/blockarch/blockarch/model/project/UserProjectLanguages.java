package com.blockarch.blockarch.model.project;

import com.blockarch.blockarch.model.project.UserProject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class UserProjectLanguages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_project_id")
    @JsonIgnore
    private UserProject userProject;

    private Boolean java;
    private Boolean kotlin;
    private Boolean scala;
    private Boolean rust;
    private Boolean python;
    private Boolean go;
    private Boolean solidity;
    
    public UserProjectLanguages() {
    }

    public UserProjectLanguages(Long id,
                                UserProject userProject,
                                Boolean java,
                                Boolean kotlin,
                                Boolean scala,
                                Boolean rust,
                                Boolean python,
                                Boolean go,
                                Boolean solidity) {
        this.id = id;
        this.userProject = userProject;
        this.java = java;
        this.kotlin = kotlin;
        this.scala = scala;
        this.rust = rust;
        this.python = python;
        this.go = go;
        this.solidity = solidity;
    }
}
