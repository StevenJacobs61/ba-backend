package com.blockarch.blockarch.model.dlt;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DltParticipants {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private DltSolution dltSolutionId;

    private Integer individuals;
    private Integer companies;
    private Integer ngo;
    private Integer governmentBody;
    private Integer consortia;

    public DltParticipants(){

    };
    public DltParticipants(
            Long id,
            DltSolution dltSolutionId,
            Integer individuals,
            Integer companies,
            Integer ngo,
            Integer governmentBody,
            Integer consortia
    ){
        this.id = id;
        this.dltSolutionId = dltSolutionId;
        this.individuals = individuals;
        this.companies = companies;
        this.ngo = ngo;
        this.governmentBody = governmentBody;
        this.consortia = consortia;
    }
}
