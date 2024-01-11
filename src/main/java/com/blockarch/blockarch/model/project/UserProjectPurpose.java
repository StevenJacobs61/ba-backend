package com.blockarch.blockarch.model.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProjectPurpose {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @OneToOne
    private UserProject userProject;
    private Boolean business;
    private Boolean personal;
    private Boolean government;
    private Boolean research;

    public UserProjectPurpose() {
    }

    public UserProjectPurpose(Long id,
                              UserProject userProject,
                              Boolean business,
                              Boolean personal,
                              Boolean government,
                              Boolean research) {
        this.id = id;
        this.userProject = userProject;
        this.business = business;
        this.personal = personal;
        this.government = government;
        this.research = research;

    }
}

