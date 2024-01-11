package com.blockarch.blockarch.model.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProjectNetworkParticipantsDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userProjectId;
    private Boolean individuals;
    private Boolean companies;
    private Boolean ngo;
    private Boolean governmentBody;
    private Boolean consortia;

    public UserProjectNetworkParticipantsDTO() {
    }

    public UserProjectNetworkParticipantsDTO(Long id,
                                          Long userProjectId,
                                          Boolean individuals,
                                          Boolean companies,
                                          Boolean ngo,
                                          Boolean governmentBody,
                                          Boolean consortia) {
        this.id = id;
        this.userProjectId = userProjectId;
        this.individuals = individuals;
        this.companies = companies;
        this.ngo = ngo;
        this.governmentBody = governmentBody;
        this.consortia = consortia;
    }
}
