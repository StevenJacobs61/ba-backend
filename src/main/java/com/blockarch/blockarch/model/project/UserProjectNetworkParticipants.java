package com.blockarch.blockarch.model.project;

import com.blockarch.blockarch.model.project.UserProject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProjectNetworkParticipants {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private UserProject userProject;

    private Boolean individuals;
    private Boolean companies;
    private Boolean ngo;
    private Boolean governmentBody;
    private Boolean consortia;

    public UserProjectNetworkParticipants() {
    }

    public UserProjectNetworkParticipants(Long id,
                                          UserProject userProject,
                                          Boolean individuals,
                                          Boolean companies,
                                          Boolean ngo,
                                          Boolean governmentBody,
                                          Boolean consortia) {
        this.id = id;
        this.userProject = userProject;
        this.individuals = individuals;
        this.companies = companies;
        this.ngo = ngo;
        this.governmentBody = governmentBody;
        this.consortia = consortia;
    }
}
