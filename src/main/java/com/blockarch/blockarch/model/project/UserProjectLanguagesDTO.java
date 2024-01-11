package com.blockarch.blockarch.model.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class UserProjectLanguagesDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userProjectId;
    private Boolean java;
    private Boolean kotlin;
    private Boolean scala;
    private Boolean rust;
    private Boolean python;
    private Boolean go;
    private Boolean solidity;

    public UserProjectLanguagesDTO() {
    }

    public UserProjectLanguagesDTO(Long id,
                                   Long userProjectId,
                                   Boolean java,
                                   Boolean kotlin,
                                   Boolean scala,
                                   Boolean rust,
                                   Boolean python,
                                   Boolean go,
                                   Boolean solidity) {
        this.id = id;
        this.userProjectId = userProjectId;
        this.java = java;
        this.kotlin = kotlin;
        this.scala = scala;
        this.rust = rust;
        this.python = python;
        this.go = go;
        this.solidity = solidity;
    }
}
