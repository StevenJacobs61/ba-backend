package com.blockarch.blockarch.model.project;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProjectPurposeDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userProjectId;
    private Boolean business;
    private Boolean personal;
    private Boolean government;
    private Boolean research;

    public UserProjectPurposeDTO() {
    }

    public UserProjectPurposeDTO( Long id,
                                  Long userProjectId,
                                  Boolean business,
                                  Boolean personal,
                                  Boolean government,
                                  Boolean research) {

        this.id = id;
        this.userProjectId = userProjectId;
        this.business = business;
        this.personal = personal;
        this.government = government;
        this.research = research;

    }
}

